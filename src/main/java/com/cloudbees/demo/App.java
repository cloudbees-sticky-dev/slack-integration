package com.cloudbees.demo;

import edu.umd.cs.findbugs.annotations.CheckForNull;

public class App {

    public void doSomething(){
        String f = getStringorNull();
        System.out.println(f);
        //"".equals(f);
    }

    @CheckForNull
    public String getStringorNull(){
        return null;
    }
}
