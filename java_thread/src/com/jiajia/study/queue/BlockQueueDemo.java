package com.jiajia.study.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 阻塞队列
 * @author : zjj
 * @date : 2020/12/21 16:54
 */
public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
//        testArrayBlockQueue();
//        testArrayBlockingQueueTwo();

        testSynchronousQueue();
    }


    /**
     * 向 arrayBlockingQueue中添加元素，当队列满了，还往里面加的话，就会抛出异常。
     */
    private static void testArrayBlockQueue(){
        // 要有初始化大小
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("aaaa");
        blockingQueue.add("bbbb");
        blockingQueue.add("cccc");


        System.out.println(blockingQueue.remove( ));
        System.out.println(blockingQueue.remove( ));
        System.out.println(blockingQueue.remove( ));

        System.out.println(
                blockingQueue.remove( )  // java.util.NoSuchElementException
        );


        //System.out.println(blockingQueue.add("zzzzz"));  // 抛异常：Exception in thread "main" java.lang.IllegalStateException: Queue full
    }

    public static void testArrayBlockingQueueTwo(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");

        System.out.println(blockingQueue.offer("d"));

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();

        System.out.println(
                blockingQueue.poll()
        );
    }

    public static void testArrayBlockingQueueThree() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();

    }

    public static void testSynchronousQueue() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        blockingQueue.put("a");

        blockingQueue.put("b");

        blockingQueue.take();

    }
}
