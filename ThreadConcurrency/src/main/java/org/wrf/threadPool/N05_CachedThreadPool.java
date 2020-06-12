package org.wrf.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CachedThreadPool基本用法 <br>
 *
 * @className: N05_CachedThreadPool
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 09:10:34
 */
public class N05_CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println(executor);
        for (int i = 0; i < 2; i++) {
            executor.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(executor);
        TimeUnit.SECONDS.sleep(500);
        System.out.println(executor);
    }
}
