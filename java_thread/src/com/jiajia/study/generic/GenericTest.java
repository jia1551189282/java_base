package com.jiajia.study.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zjj
 * @date : 2020/12/23 17:43
 */
public class GenericTest {

    public static void main(String[] args) {
        test3();
    }

    public void test1(){

        // 在继承的时候已经父类已经确定了泛型类型，所以子类就不用声明了。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT("佳佳");
        // 继承的时候没有确定泛型，所以子类可以声明泛型类型，如果不指出默认是Object
        SubOrder1<Integer> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT(1);


    }

    /**
     * 泛型类型不一样的接口或者类不能相互赋值。
     *
     */
    public void test2(){
        List<Integer> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        // 泛型的应用不能相互赋值
//        list = list1; // 编译不通过

        // 但是泛型引用中的泛型类型是一样的，就可以了
        List<Integer> list2 = new ArrayList<>();
        list = list2;


    }

    /**
     * 泛型方法的使用
     */
    public static void test3(){

        Order<String> order = new Order<>();
        // 泛型方法和泛型类没有关系，是在调用的时候才确定的
        Integer orderId = order.getOrderId(10);
        String 佳佳 = order.getOrderId("佳佳");
    }


    /**
     * List<Object> 和 list<Integer>、List<String>等都没有父子类关系
     * 都是不同的类型
     * 为了可以有一个统一的父类
     * 这样就可以使用多态了
     * 这个父类就是List<?>
     *
     * */
    public static void test4(){
        List<?> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list = list2;
        list = list3;

//        list1 = list2;



    }
}
