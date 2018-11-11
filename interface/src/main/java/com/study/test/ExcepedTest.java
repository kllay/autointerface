package com.study.test;

import org.testng.annotations.Test;

//异常测试
public class ExcepedTest {
    @Test(expectedExceptions=RuntimeException.class)
    public void test1(){
        System.out.println("test111");
        throw new RuntimeException();
    }

    @Test(expectedExceptions=RuntimeException.class)
    public void test22222(){
        System.out.println("test2222222222222");

    }

}
