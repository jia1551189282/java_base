package com.jiajia.study;

/**
 * @author zjiajia
 * @date 2020/8/28 9:42
 *
 * 创建线程的方式 一： 继承Thread ,重写run方法（自己的逻辑）
 */
public class ThreadDemo1 extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()  + ":" +  i);
            }

        }
    }
}
