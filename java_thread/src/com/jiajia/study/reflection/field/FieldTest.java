package com.jiajia.study.reflection.field;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author : zjj
 * @date : 2020/12/24 10:32
 */
public class FieldTest {

    public static void main(String[] args) {

        //test1();;
        test2();
    }

    /**
     * 获取类的属性
     * 全部属性
     * 本类声明的属性
     */
    public static void test1(){
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }

        System.out.println("=====================");

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field: declaredFields) {
            System.out.println(field);
        }
    }

    /**
     * 获取属性的信息
     * 属性的名称
     * 属性的权限修饰
     * 属性的类型
     */
    public static void test2(){

        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field:declaredFields
             ) {
            // 获取到属性的名称
            String name = field.getName();
            System.out.println("属性名称：" + name);

            // 属性的修饰符
            int modifiers = field.getModifiers();
            System.out.println("属性的权限修饰符：" + modifiers);

            // 属性的类型
            Class<?> type = field.getType();
            System.out.println("属性的类型：" + type.getName());

            if(field.getType() == List.class){
                Type genericType = field.getGenericType();
                System.out.println("实际的参数类型：" + genericType);
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                System.out.println("泛型的类型："+actualTypeArguments[0]);
            }
            System.out.println("===================================");
        }

    }
}
