package com.beat.chen.baseapi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {
    //id
    private String id;
    //姓名
    private String name;
    //年龄
    private int age;

    @Override
    public String toString(){

        return "姓名："+ name+";id："+id+";年龄："+age;
    }
}
