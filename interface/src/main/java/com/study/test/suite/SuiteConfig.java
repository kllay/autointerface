package com.study.test.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void besutieTest(){
        System.out.println("befor suite 运行了");
    }
    @AfterSuite
    public void afsuiteTest(){
        System.out.println("after suite 运行了");
    }

    @BeforeTest
    public void betest(){
        System.out.println("befor tests");
    }

    @AfterTest
    public void aftest(){
        System.out.println("after tests");
    }



}
