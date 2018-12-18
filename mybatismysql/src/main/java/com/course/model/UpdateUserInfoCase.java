package com.course.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private  int id;
    private  int userid;
    private String userName;
    private  int sex;
    private  int age;
    private  int permission;
    private int isDelete;
    private  String expected;
}
