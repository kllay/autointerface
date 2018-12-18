package com.api.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法!")
public class MyGetMethod {

    @ApiOperation(value ="这个是get cookies方法",httpMethod = "GET")
    @RequestMapping(value = "/getcookie",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest
        //HttpServletResponse
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies成功!";
    }


    //要求携带cookies的访问
    @ApiOperation(value ="要求携带cookies的访问",httpMethod = "GET")
    @RequestMapping(value = "/get/with/cookie",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){ //判断是否为空
            return "请携带cookies请求!";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                return "请求成功！恭喜你";
            }
        }
        return "请携带cookies请求!";
    }

    //开发一个需要携带参数的get请求  第一种方法
    //模式 key=vale&key=value
    //来模拟商品列表
    //http://127.0.0.1:8080/get/with/param?start=1&end=34
    @ApiOperation(value ="开发一个需要携带参数的get请求  第一种方法",httpMethod = "GET")
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getWithParams(@RequestParam Integer start,
                                            @RequestParam Integer end){
        Map<String,Integer> maps=new HashMap<>();
        maps.put("鞋子",10);
        maps.put("书",45);
        maps.put("笔",9);

        return  maps;

    }

    //第二种方法
    //ip/get/with/param/10/20
    //http://127.0.0.1:8080/get/with/param/23/44
    @ApiOperation(value ="开发一个需要携带参数的get请求  第二种方法",httpMethod = "GET")
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    public Map getWithParamsMapp(@PathVariable Integer start,
                                             @PathVariable Integer end){
        Map<String,Integer> maps=new HashMap<>();
        maps.put("鞋子1",10);
        maps.put("书1",45);
        maps.put("笔1",9);

        return  maps;

    }














}
