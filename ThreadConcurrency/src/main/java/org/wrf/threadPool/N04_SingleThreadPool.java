package org.wrf.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadPool 基本用法 <br>
 *
 * @className: N04_SingleThreadPool
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 09:06:36
 */
public class N04_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j=i;
            executor.execute(()->{
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
    }
}
