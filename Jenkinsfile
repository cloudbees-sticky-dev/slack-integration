pipeline {//1
    agent none

    stages {//2
        stage("build"){//3
            agent any
            steps{//4
               echo '[simulate] mvn --show-version --batch-mode --errors --no-transfer-progress -Dmaven.test.failure.ignore=true -Dspotbugs.failOnError=false  clean verify'
               script {
                       def testResults = findFiles(glob: '**/target/surefire-reports/TEST-*.xml')
                       for(xml in testResults) {
                           touch xml.getPath()
                       }
                   }
               junit '**/target/surefire-reports/TEST-*.xml'
               recordIssues(tool: spotBugs(), qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]])
            }//4
        }//3
    }//2
}//1
