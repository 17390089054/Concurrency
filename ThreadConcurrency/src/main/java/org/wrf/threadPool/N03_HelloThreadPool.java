package org.wrf.threadPool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExector基本用法 <br>
 *
 * @className: HelloThreadPool
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 23:14:04
 */
public class N03_HelloThreadPool {
    static class Task implements Runnable{
        private  int i;
        public Task(int i){
            this.i=i;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" Task "+i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor tpe=new ThreadPoolExecutor(2,4,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(4), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 8; i++) {
            tpe.execute(new Task(i));
        }
        System.out.println(tpe.getQueue());
        tpe.execute(new Task(100));
       System.out.println(tpe.getQueue());
        tpe.shutdown();
    }
}
