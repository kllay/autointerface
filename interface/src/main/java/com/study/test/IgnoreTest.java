package com.study.test;

import org.testng.annotations.Test;

public class IgnoreTest {
    //忽略测试
    @Test
    public  void  test1(){
        System.out.println("test111111111");
    }
    @Test(enabled = false)
    public  void  test2(){
        System.out.println("test22222222222");
    }
    @Test(enabled = true)
    public  void  test3(){
        System.out.println("test33333333333");
    }

}
