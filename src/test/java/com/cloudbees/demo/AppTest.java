package com.cloudbees.demo;

import org.junit.Test;

import static org.junit.Assert.fail;

public class AppTest {

    @Test
    public void test_fail(){
        App app = new App();
        app.doSomething();
        //fail();
        //assertTrue(true);
        fail();
    }
}
