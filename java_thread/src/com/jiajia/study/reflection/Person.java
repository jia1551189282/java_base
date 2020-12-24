package com.jiajia.study.reflection;

import java.util.List;

/**
 * @author : zjj
 * @date : 2020/12/21 11:58
 */
public class Person {


    public Person() {

        System.out.println("无参构造方法被调用");
    }

    public Person(String username, Integer gender, List<Pet> petList) {
        this.username = username;
        this.gender = gender;
        this.petList = petList;
    }

    public String username;

    public Integer gender ;

    public List<Pet> petList;

}
