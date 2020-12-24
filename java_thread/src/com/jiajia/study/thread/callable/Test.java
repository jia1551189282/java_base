package com.jiajia.study.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : zjj
 * @date : 2020/12/23 8:50
 */
public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }

    /**
     * callable 的使用
     * @throws ExecutionException   异常
     * @throws InterruptedException 异常
     */
    public void testCallable() throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyCallable());

        Thread thread = new Thread(task);
        thread.start();

        // 这里会等待拿到结果，才会往下执行
        Object o = task.get();

        System.out.println("主线程执行完成");
    }

    /**
     * futureTask  实现了 runnable 接口 ，并且构造方法里面和callable有关
     * 所以可以用这样方式来创建线程，而且 callable 的方式可以有返回结果
     */
    public void testCallableDemo(){
        FutureTask task = new FutureTask(() -> {

            return "hello,callable demo";
        });
        // 稍微复杂一点的方式来启动线程
        Thread thread = new Thread(task);
        thread.start();

        // 简单的方式来启动线程
        new Thread(new FutureTask<String>(() ->{
            System.out.println("线程被调用了");
          return "hello , callable demo ";
        })).start();
    }
}
