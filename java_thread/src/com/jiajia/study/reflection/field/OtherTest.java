package com.jiajia.study.reflection.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 利用反射获取类的一些其它属性
 *
 * 父类的一些属性
 * 本类注解的一些属性
 * 实现接口的一些属性
 *
 * @author : zjj
 * @date : 2020/12/24 14:14
 */
public class OtherTest {


    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();

        test7();
    }


    /**
     * 获取类的构造器
     */
    private static void test1(){

        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor constructor: constructors
             ) {
            System.out.println("所有的构造器：" + constructor);
        }
        System.out.println("=========================================================");
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor constructor:declaredConstructors
             ) {
            System.out.println("自己的构造器：" + constructor);

        }

    }

    /**
     * 获取父类
     */
    public static void test2(){

        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println("父类：" + superclass);
    }

    /**
     * 获取父类，如果有泛型，带上泛型
     */
    public static void test3(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println("父类的真实类型：" + genericSuperclass);
    }

    /**
     * 获取父类的泛型的类型
     */
    public static void test4(){

        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();

        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type type : actualTypeArguments
             ) {
            System.out.println(type.getTypeName());
        }

        for (int i = 0; i < actualTypeArguments.length; i++) {
            System.out.println(((Class)actualTypeArguments[i]).getName());
        }
    }

    /**
     * 获取运行是类的接口
     */
    private static void test5(){
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();

        for (Class<?> face: interfaces) {
            System.out.println(face.getName());;
        }
    }

    /**
     * 获取所在包
     */
    private static void test6(){

        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);

    }

    /**
     * 获取类的注解
     *
     * 以及注解的一些值
     */
    private static void test7(){

        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();

        for (Annotation annotation: annotations
             ) {
            System.out.println(annotation);
            if (annotation.annotationType() == MyClassAnnotation.class){
                MyClassAnnotation myClassAnnotation  = (MyClassAnnotation)annotation;
                String type = myClassAnnotation.type();
                String value = myClassAnnotation.value();
                System.out.println("注解value的值：" + value);
                System.out.println("注解type的值：" + type);
            }
        }

    }


}
