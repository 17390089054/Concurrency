package org.wrf.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池demo <br>
 *
 * @className: ThreadPoolDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 10:52:18
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService es=Executors.newCachedThreadPool();
        Future<String> f=es.submit(new MyCallable());
        if(!f.isDone()){
            System.out.println("task has not finished,please wait");
        }
        try {
            System.out.println("task return:"+f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
    }
}
