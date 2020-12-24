package com.jiajia.study.reflection.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * 反射获取类的方法测试
 * @author : zjj
 * @date : 2020/12/24 11:28
 */
public class MethodTest {

    public static void main(String[] args) {

//        test1();
        test2();
    }


    public static void test1(){
        Class<Person> personClass = Person.class;

        // 获取所有的方法，包含所有的父类方法，有权限限制
        Method[] methods = personClass.getMethods();
        for (Method method: methods) {
            System.out.println("所有的方法" + method);
        }
        System.out.println("==========================");
        // 获取本类的方法，不包含父类的方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method: declaredMethods
             ) {
            System.out.println("本类的方法:" + method);
        }
    }

    /**
     * 反射获取方法的属性
     * 方法的名称
     * 方法的权限范围
     * 方法的返回值
     * 方法的参数值
     * 方法的注解
     * 方法的异常
     */
    public static void test2(){
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();

        for (Method method: methods) {
            // 名称
            String name = method.getName();
            System.out.println("方法的名称：" + name);

            // 权限修饰符
            int modifiers = method.getModifiers();
            System.out.println("权限修饰符：" + modifiers);

            // 返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.println("返回值类型：" + returnType.getName());

            // 注解名
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation: annotations
                 ) {
                System.out.println("   注解名：" + annotation);
                if(annotation.annotationType() == MyAnnotation.class){
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    String[] names = myAnnotation.names();
                    String value = myAnnotation.value();
                    System.out.println("    注解value值：" + value);
                    for (String nameStr:names
                         ) {
                        System.out.println("            注解name值：" + nameStr );
                    }
                }
            }

            // 参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterizedType: parameterTypes
                 ) {
                System.out.println("    参数列表：" + parameterizedType.getName());
            }

            // 异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> e :
                    exceptionTypes) {
                System.out.println("    异常：" + e.getName());
            }

            System.out.println("=====================================");
        }
    }
}
