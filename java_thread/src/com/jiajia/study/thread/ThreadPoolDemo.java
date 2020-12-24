package com.jiajia.study.thread;

import java.util.concurrent.*;

/**
 *
 * 线程池demo
 * @author : zjj
 * @date : 2020/12/21 9:24
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
       /* // 固定线程池大小
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        try{
            for (int i = 0; i < 10; i++) {
                final  int tempInt = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "：给用户" + (tempInt) + "提供服务");
                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }*/

        // 手写线程池
        testThreadPool();
    }

    public static void testThreadPoolExecutor(){
        // 创建5 个线程的线程池  -- 用的阻塞队列是  new LinkedBlockingQueue<Runnable>());  默认阻塞队列的大小是  Integer.MAX
        // 如果一下子有很多请求过来的话，那么就会造成OOM
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 带缓存的线程池,没有规定线程池的大小
        // 默认常驻线程是 0 corePoolSize ，但是最大线程数是Integer.MAX 这样可能会创建大量的线程。从而也会出现OOM
        ExecutorService threadPool1 = Executors.newCachedThreadPool();

    }


    public static void  testThreadPool(){

        int  corePoolSize = 2 ;
        int  maximumPoolSize = 5;
        Long  keepAliveTime = 5L ;
        int blockQueueSize = 5;
        ExecutorService executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(blockQueueSize),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


        try{
            for (int i =  0; i < 10 ; i++){
                final  int  temtInt = i;
                executorService.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "执行任务" + temtInt);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }




}
