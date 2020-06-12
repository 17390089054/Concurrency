package org.wrf.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Future基本用法
 *
 * @className: N01_Future
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 22:45:24
 */
public class N01_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task=new FutureTask<Integer>(()->{
            TimeUnit.SECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();
        System.out.println(task.get());
    }
}
