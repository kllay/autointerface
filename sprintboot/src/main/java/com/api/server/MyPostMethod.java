package com.api.server;

import com.api.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//post请求
@RestController
@Api(value ="/",description = "这是全部post请求")
@RequestMapping( "/v1")   //所有的路径都加v1
public class MyPostMethod {

    //设置cookies
    private  Cookie cookie=null;
    //登录接口
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，获取cookies信息!",httpMethod = "POST")    //required 请求是否毕传
    public String Login(HttpServletResponse response, @RequestParam(value = "userName",required = true) String userName,
                                                      @RequestParam(value = "passWord",required = true) String passWord){

        if(userName.equals("zhuzai")&& passWord.equals("123456")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜您"+userName+"登录成功!";
        }
        return  "用户名或密码错误！";

    }

    //获取用户列表
    @RequestMapping(value = "/getuserlist",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
        //初始化
        User user;
        Cookie[] cookies=request.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("login")
                    &&c.getValue().equals("true")
                    && u.getUserName().equals("zhuzai")
                    && u.getPassWord().equals("123456")){
                    user=new User();
                    user.setName("wangwu");
                    user.setAge("12");
                    user.setSex("man");

                    return  user.toString();
            }
        }

        return "参数不合法";


    }




}
