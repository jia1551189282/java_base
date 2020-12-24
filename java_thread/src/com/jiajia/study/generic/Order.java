package com.jiajia.study.generic;

/**
 * 自定义泛型类，类中带有泛型，类中就可以使用泛型
 * @author : zjj
 * @date : 2020/12/23 17:43
 */
public class Order<T> {


    private Long id;

    private T orderT;


    public void setOrderT(T orderT){
        this.orderT = orderT;
    }


    public Order(){
        // 这样使用是不对的，编译不通过，初始化的时候不确定是什么类型就会编译不通过
//        T[] arr = new T[10];
        // 泛型数组的使用，这样是正确的，可以先初始化成Object 然后转乘T[]
        T[] arr = (T[])new Object[10];
    }

    /**
     * 这里不是泛型方法，只是用到了类的泛型
     * @return
     */
    public T getName(){
        return null;
    }

    /**
     * 静态方法不能使用泛型，因为泛型只能在运行的时候确定，而静态方法在类加载的时候就要确定类型
     * @return
     */
    /*private static T getCode(){
        return null;
    }*/

    /**
     * 这才是泛型方法 ，主要要在方法前面声明一下泛型的类型
     * 泛型方法和类的泛型没有关系。
     * 泛型方法可以是静态方法，因为参数是在方法调用的时候确定的，不是在类实例化的时候确定的
     * @param e
     * @param <E>
     * @return
     */
    public <E> E  getOrderId(E e){
        return e;
    }
}
