package com.jiajia.study.annotation;

/**
 * 自定义注解
 * @author : zjj
 * @date : 2020/12/21 11:21
 */
public @interface MyAnnotation {
    /**
     * 注解的值
     * @return 注解的值
     */
    String value() default "";

    /**
     * 姓名
     * @return
     */
    String[] names();
}
