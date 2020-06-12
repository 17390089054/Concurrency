package org.wrf.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo<br>
 *
 * @className: SemaphoreDemo
 * @package: org.wrf.juc
 * @author: knight
 * @date: 2020-05-15 22:02:04
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //控制5个线程访问
        Semaphore semaphore=new Semaphore(5);
        //创建20个客户端进行访问
        for (int index=0;index<20;index++){
            final int No=index;
            Runnable run= () -> {
                try {
                    //获取许可
                    semaphore.acquire();
                    System.out.println("Accessing: "+No);
                    Thread.sleep((long)(Math.random()*10000));
                    //访问完后，释放
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }
}
