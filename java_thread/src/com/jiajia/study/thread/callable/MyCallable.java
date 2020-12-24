package com.jiajia.study.thread.callable;

import java.util.concurrent.Callable;

/**
 *
 * @author : zjj
 * @date : 2020/12/23 8:49
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("callable 被调用");

        Thread.sleep(3*1000);


        return "hello，callable";
    }
}
