package com.jiajia.study.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author : zjj
 * @date : 2020/12/21 12:00
 */
public class ReflectionDemo {

    public static void main(String[] args) {
        Class clazz = Person.class;

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.getType() == List.class){
                System.out.println(field.getType());
                System.out.println(field.getGenericType());
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];

                System.out.println(actualTypeArgument);
            }

        }
    }
}
