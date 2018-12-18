package com.course.httpclient.test;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesHttpClient {

    private  String url;
    private ResourceBundle bundle;
    CookieStore store;

    @BeforeTest
    public  void beforeTest(){
        //找到配置文件
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");

    }

    @Test
    public  void testGetCookies() throws IOException {
        String result;
        //拼接url
        String uri=bundle.getString("getcoolies.uri");
        String testUrl=this.url+uri;

        HttpGet get=new HttpGet(testUrl);
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies内容
         this.store=((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookielist= store.getCookies();
        for(Cookie cookie:cookielist){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookiename="+name
            +"cookie value="+value);
        }



    }

    //依赖上面的方法 设置cookie
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri=bundle.getString("test.get.with.cookies.uri");
        String testUrl=this.url+uri;

        HttpGet get=new HttpGet(testUrl);
        HttpClient client=new DefaultHttpClient();

        //设置cookies信息
        ((DefaultHttpClient) client).setCookieStore(this.store);
        HttpResponse response=client.execute(get);

        //获取状态码
        int statuscode=response.getStatusLine().getStatusCode();
        System.out.println("status code="+statuscode);

        if(statuscode==200){
            result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }











    }





}
