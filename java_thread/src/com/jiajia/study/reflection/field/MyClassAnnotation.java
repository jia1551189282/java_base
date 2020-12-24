package com.jiajia.study.reflection.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author : zjj
 * @date : 2020/12/24 14:41
 */

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyClassAnnotation {

    /**
     * 值
     * @return 值
     */
    String value() default "";

    /**
     * 类型
     * @return 类型
     */
    String type();
}
