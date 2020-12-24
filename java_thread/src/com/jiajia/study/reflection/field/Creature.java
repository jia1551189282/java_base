package com.jiajia.study.reflection.field;

/**
 *
 * 生物
 * @author : zjj
 * @date : 2020/12/24 10:32
 */
public class Creature<T> {
    /**
     * 年龄
     */
    private char gender;
    /**
     * 体重
     */
    public Double weight ;

    private void breath(){
        System.out.println("动物需要呼吸");
    }

    private void eat(){
        System.out.println("动物需要饮食");
    }
}
