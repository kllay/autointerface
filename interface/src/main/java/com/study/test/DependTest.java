package com.study.test;

import org.testng.annotations.Test;

//依赖测试
public class DependTest {

    @Test
    public  void test1(){
        System.out.println("test111111111");
    }

    //依赖test1执行
    @Test(dependsOnMethods = {"test1"})
    public  void  test2(){
        System.out.println("test222222222");
    }

    @Test
    public  void  test3(){
        System.out.println("test33333333333");
        throw new RuntimeException();
    }
    //依赖test1执行
    @Test(dependsOnMethods = {"test3"})
    public  void  test4(){
        System.out.println("test4444444");
    }


}
