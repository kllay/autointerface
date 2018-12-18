package com.course.cases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.model.InterFaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作")
    public void beforeTest(){
        TestConfig.getUserInfoUrl= ConfigFile.getUrl(InterFaceName.GETUSERINFO);
        TestConfig.getUserListUrl=ConfigFile.getUrl(InterFaceName.GETUSERLIST);
        TestConfig.addUserUrl=ConfigFile.getUrl(InterFaceName.ADDUSERINFO);
        TestConfig.loginUrl=ConfigFile.getUrl(InterFaceName.LOGIN);
        TestConfig.updateUserInfoUrl=ConfigFile.getUrl(InterFaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient=new DefaultHttpClient();

    }

    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //发送请求
        String result=getResult(loginCase);

        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);

    }



    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //发送请求
        String result=getResult(loginCase);

        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    //获取结果
    private String getResult(LoginCase loginCase) throws IOException {

        HttpPost post=new HttpPost(TestConfig.loginUrl);
        JSONObject param=new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        post.setHeader("Content-Type","application/json");
        StringEntity entity=new StringEntity(param.toString(),"utf-8");

        post.setEntity(entity);

        String result;
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        result= EntityUtils.toString(response.getEntity(),"utf-8");

        TestConfig.store=TestConfig.defaultHttpClient.getCookieStore();
        return  result;

    }




}
