package org.wrf.threadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * WorkStealingPool 基本用法 <br>
 *
 * @className: N09_WorkStealingPool
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 11:07:14
 */
public class N09_WorkStealingPool {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        System.in.read();

    }

     static class R implements Runnable {
        int time;

         R(int i) {
            this.time=i;
        }

         @Override
         public void run() {
             try {
                 TimeUnit.MICROSECONDS.sleep(time);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println(time+" "+Thread.currentThread().getName());
         }
     }
}
