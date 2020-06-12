package org.wrf.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall!");
            return "success";
        }
    }

    //创建线程的5种方式
    public static void main(String[] args) {
        //thread
        new MyThread().start();
        //runnable
        new Thread(new MyRun()).start();
        //lambda
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();
        //callable
        new Thread(new FutureTask<String>(new MyCall())).start();
        //ThreadTool
        ExecutorService es=Executors.newCachedThreadPool();
        es.execute(() -> {
            System.out.println("Hello ThreadPool!");
        });
        es.shutdown();
    }
}
