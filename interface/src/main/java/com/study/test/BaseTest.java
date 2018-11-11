package com.study.test;

import org.testng.annotations.*;

public class BaseTest {

    @Test
    public void baseTest(){
        System.out.println("test11");
    }

    @Test
    public void test2(){
        System.out.println("test222222222222");
    }

    @BeforeMethod
    public void testbefMethod(){
        System.out.println("BeforeMethod每个测试方法之前运行!");
    }

    @AfterMethod
    public  void testAftMethod(){
        System.out.println("AfterMethod每个测试方法之后运行!");
    }

    @BeforeClass
    public void befClass(){
        System.out.println("BeforeClass这个测试类运行前执行！***********");
    }

    @AfterClass
    public void aftClass(){
        System.out.println("AfterClass这个类之后运行!***********");
    }

    @BeforeSuite
    public  void besutieTest(){
        System.out.println("beforrsuite Test测试套件运行");
    }

    @AfterSuite
    public  void afersuiteTest(){
        System.out.println("aftersutie test套件后运行");
    }





}
