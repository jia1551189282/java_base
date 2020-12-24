package com.jiajia.study.reflection;

/**
 * @author : zjj
 * @date : 2020/12/24 10:11
 */
public class ReflectionTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        test2();
    }

    /**
     * 获取Class类实例的方法
     */
    public static   void test1() throws ClassNotFoundException {
        // 调用运行是类的属性
        Class<Person> personClass = Person.class;
        // 通过运行时类的对象的方法
        Person person  = new Person();
        Class personClass1 = person.getClass();

        // 调用类的静态方法 .forName
        Class person1 = Class.forName("com.jiajia.study.reflection.Person");

        // 使用类加载器
        Class personClass4 = ReflectionTest.class.getClassLoader().loadClass("com.jiajia.study.reflection.Person");

    }

    /**
     * 通过反射的方式创建对象
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void test2() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;

        Person person = personClass.newInstance();

        System.out.println(person);



    }
}
