pipeline {

    agent none
    environment {
            // tools
            MAVEN_TOOL = "maven3"
        }

      tools {
            maven MAVEN_TOOL
        }
    stages {
        stage("stuff"){
            agent any
            steps{
                sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false  clean verify'
            }
        }
        stage("build"){
            agent any
            steps{
                sh 'mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false  clean verify'
                 junit '**/target/surefire-reports/TEST-*.xml'
                    recordIssues(
                           tool: spotBugs(), qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]])
                }
            }
        }
    }
}
