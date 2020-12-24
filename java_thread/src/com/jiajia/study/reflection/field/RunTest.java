package com.jiajia.study.reflection.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 *
 * 调用运行时类中指定结构
 * @author : zjj
 * @date : 2020/12/24 14:51
 */
public class RunTest {

    public static void main(String[] args) throws Exception {
//        test2();
//        test3();

//        test4();
        test5();
    }

    /**
     * 属性,只能是public 类型的
     */
    private static void testField() throws Exception {

        Class<Person> personClass = Person.class;

        Person person = personClass.newInstance();

        Field id = personClass.getField("id");
        // 参数1：设置的对象
        // 参数2：设置的值
        id.set(person,10);
        // 得到对象当前属性的值
        Integer personId = (Integer) id.get(person);
        System.out.println("获取到对象的值：" + personId);

    }

    /**
     * 操作本类的属性。 包含私有属性
     * @throws Exception
     */
    private static void test2()throws  Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Field name = personClass.getDeclaredField("name");
        // 设置属性可以访问
        name.setAccessible(true);

        name.set(person,"玊玊");
        String nameValue = (String)name.get(person);
        System.out.println("person对象的name属性的值设置成了" + nameValue);

    }

    /**
     * 操作类中指定的方法
     */
    public static void test3()throws Exception{

        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();


        Method run = personClass.getDeclaredMethod("run",Date.class,Long.class);
        // 设置可以访问
        run.setAccessible(true);
        // 执行方法
        run.invoke(person,new Date(),20L);
    }

    /**
     * 静态方法的调用
     * @throws Exception 异常
     */
    public static void test4()throws Exception{

        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Method sayHello = personClass.getDeclaredMethod("sayHello", String.class);
        sayHello.setAccessible(true);

        String result =(String) sayHello.invoke(Person.class, "编程世界");
        System.out.println(result);
    }

    /**
     * 调用类的指定构造器
     * @throws Exception    异常
     */
    private static void test5()throws Exception{

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class);

        constructor.setAccessible(true);

        Person person = constructor.newInstance("玊玊");

        System.out.println(person);


    }




}
