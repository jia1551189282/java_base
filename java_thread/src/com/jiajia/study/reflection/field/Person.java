package com.jiajia.study.reflection.field;

import java.util.Date;
import java.util.List;

/**
 * @author : zjj
 * @date : 2020/12/24 10:35
 */

@MyClassAnnotation(value = "hello",type="自建")
public class Person extends Creature<String> implements MyInterface {

    private String name;

    public int age ;

    int id;

    public List<Pet> pets;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", pets=" + pets +
                '}';
    }

    @Override
    public void palyGames() {
        System.out.println("打游戏");
    }


    @MyAnnotation(value = "跑步",names = {"佳佳","小龙"})
    public void run(Date startTime,Long times){
        System.out.println("有的人喜欢跑步");

        System.out.println("小龙，每天" + startTime + "开始跑步，" + "跑：" + times + "分钟");
    }

    /**
     * 打招呼
     * @param word  招呼内容
     * @return      返回招呼内容
     */
    private static String sayHello(String word){

        return "你好" + word;
    }
}
