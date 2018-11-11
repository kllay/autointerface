package com.study.test.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public  void test1(){
        System.out.println("groupclass2 中的test1111 运行");
    }
    public  void test2(){
        System.out.println("groupclass2 中的test2222 运行");
    }
}
