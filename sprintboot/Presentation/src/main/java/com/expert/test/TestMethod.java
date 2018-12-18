package com.expert.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

//测试报告的生成
public class TestMethod {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
        System.out.println("test1");
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaaa","aaaa");
    }

    @Test
    public void testLog(){
        Reporter.log("这是我们自己的日志!!!");
        throw new RuntimeException("这是我自己的异常信息");
    }

}
