package com.jiajia.study.reflection.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author : zjj
 * @date : 2020/12/24 10:38
 */

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    /**
     * 值
     * @return 值
     */
    String value() default "";

    /**
     * 名称
     * @return  名称
     */
    String[] names();
}
