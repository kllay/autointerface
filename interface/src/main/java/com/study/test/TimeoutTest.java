package com.study.test;

import org.testng.annotations.Test;

//超时测试
public class TimeoutTest {

    //毫秒
    @Test(timeOut = 3000)
    public  void test1() throws InterruptedException {
        System.out.println("test11111111");
        Thread.sleep(2000);
    }

}
