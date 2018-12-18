package com.course.httpclient.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //用来储存结果
        String result;
        //创建get请求
        HttpGet get=new HttpGet("http://www.baidu.com");
        //创建一个执行对象
        HttpClient client=new DefaultHttpClient();
        //执行get请求并返回
        HttpResponse response =client.execute(get);
        //转换响应信息为string类型
         result=EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);


    }

}
