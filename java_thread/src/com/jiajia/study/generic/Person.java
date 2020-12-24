package com.jiajia.study.generic;

import java.util.List;

/**
 * @author : zjj
 * @date : 2020/12/21 11:35
 */
public class Person<T> {

    private String username ;

    private Integer gender ;

    /**
     * 宠物
     */
    private List<Pet> petList;

    /**
     *
     * @param t 泛型类型
     * @return  泛型类型
     */
    private T getHello(T t){
        return  t;
    }

    /**
     * 不确定要返回的类型的时候，就可以用泛型方法
     * @param <E>
     * @return
     */
    private <E> E getName(){
        return null ;
    }
}
