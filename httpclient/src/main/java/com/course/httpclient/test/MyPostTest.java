package com.course.httpclient.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyPostTest {
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
    public void myPostTest() throws IOException {

        //拼接url
        String uri=bundle.getString("post.uri");
        String testUrl=this.url+uri;

        //声明一个client对象，用来执行方法
        DefaultHttpClient client=new DefaultHttpClient();

        //声明一个方法，这个方法是post
        HttpPost post=new HttpPost(testUrl);

        //添加参数
        //创建一个json对象
        JSONObject param=new JSONObject();
        param.put("name","xiaozhu");
        param.put("sex","22");

        //设置请求头信息 header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity =new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(store);
        //执行post方法
        HttpResponse response=client.execute(post);
        //获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，是否符合预期
        //将返回的响应结果字符串转为json对象
        JSONObject resultJson=new JSONObject(result);

        //获取到结果值
        String sucess=(String) resultJson.get("wanglaosi");
        String status=(String) resultJson.get("status");
        //具体判断返回的结果值
        Assert.assertEquals("hhhhhhhhhhhh",sucess);
        Assert.assertEquals("200",status);












    }


}
