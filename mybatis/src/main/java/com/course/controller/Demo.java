package com.course.controller;

import  com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1",description = "这是我第一个demo")
@RequestMapping("v1")
public class Demo {

    //首先执行一个sql语句对象
    @Autowired   //启动时加载
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getusercount",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数",httpMethod = "GET")
    public int getUserList(){
        return  template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户" ,httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return  template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return  template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteuser",method = RequestMethod.GET)
    public int deleteUser(@RequestParam int id ){
        return template.delete("deleteUser",id);
    }


}
