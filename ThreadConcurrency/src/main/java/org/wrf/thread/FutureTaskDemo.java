package org.wrf.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  Callable接口调用 <br>
 *
 * @className: FutureTaskDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 10:24:39
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft=new FutureTask<>(new MyCallable());
        new Thread(ft).start();
        if(!ft.isDone()){
            System.out.println("task has not finished,please wait");
        }
        System.out.println("task return:"+ft.get());
    }
}
