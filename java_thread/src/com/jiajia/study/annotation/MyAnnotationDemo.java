package com.jiajia.study.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 *
 * 元注解的使用：
 * 用来定义注解的注解
 * target 表明注解可以用的位置
 * retention 表明什么时候可以拿到注解信息，只有用 Runttime 才能在反射中拿到
 *
 * 一般注解会有属性，这样反射才可以拿到一些信息，才会有意义
 *
 * @author : zjj
 * @date : 2020/12/23 17:34
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationDemo {
    /**
     * 注解的值
     * @return
     */
    String value();

    /**
     * 名称
     * @return
     */
    String[] name() default "玊玊";
}
