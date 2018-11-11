package com.study.test.groups;

import org.testng.annotations.Test;

//类上测试
@Test(groups = "stu")
public class GroupOnClass1 {
    public  void test1(){
        System.out.println("groupclass1 中的test1111 运行");
    }
    public  void test2(){
        System.out.println("groupclass1 中的test2222 运行");
    }

}
