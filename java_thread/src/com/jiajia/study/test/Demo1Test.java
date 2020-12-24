package com.jiajia.study.test;

import com.jiajia.study.thread.ThreadDemo1;

/**
 * @author zjiajia
 * @date 2020/8/28 9:45
 */
public class Demo1Test {

    public static void main(String[] args) {
        // 创建一个线程
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        // 执行线程
        threadDemo1.start();

        for (int i = 100; i <200 ; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() +  ":" + i);
            }

        }
    }
}
