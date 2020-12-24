package com.jiajia.study.annotation;


/**
 * @author : zjj
 * @date : 2020/12/21 11:22
 */
public class Person {
    private String username;

    private Integer age;

    private Integer gender;

    /**
     * 注解一般要结合反射来使用
     *
     */
    @MyAnnotationDemo(value = "晨晨" )
    @MyAnnotation(value = "zhi",names = {"1","2"})
    public void sayHello(){
        System.out.println("hello");
    }
}
