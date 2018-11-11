package com.study.test.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


//group 分组测试
public class GroupsMethond {
    @Test(groups = "server")
    public void  test1(){
        System.out.println("serve test1111111111111");
    }
    @Test(groups = "server")
    public void  test2(){
        System.out.println("serve test2222222222222");
    }
    @Test(groups = "client")
    public void  test3(){
        System.out.println("client test33333333333333");
    }
    @Test(groups = "client")
    public void  test4(){
        System.out.println("client test4444444444444444");
    }

    @BeforeGroups("server")
    public  void begroups(){
        System.out.println("这是服务组运行之前的组");
    }

    @AfterGroups("server")
    public  void afgroups(){
        System.out.println("这是服务组运行之后后的组");
    }

    @BeforeGroups("client")
    public  void begroupsclent(){
        System.out.println("这是客户端运行之前的组");
    }

    @AfterGroups("client")
    public  void afgroupsclent(){
        System.out.println("这是客户端运行之后后的组");
    }



}
