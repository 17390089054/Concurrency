package org.wrf.imooc.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 同步代码 <br>
 *
 * @className: SyncThread
 * @package: org.wrf.imooc.concurrency
 * @author: knight
 * @date: 2020-05-09 23:22:58
 */
public class SyncThread implements Runnable {
    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        if(threadName.startsWith("A")){
            asyncThread();
        }else if(threadName.startsWith("B")){
            syncObject();
        }else if(threadName.startsWith("C")){
            syncMethod();
        }else if(threadName.startsWith("D")){
            syncClass();
        }else if(threadName.startsWith("E")){
            syncStaticMethod();
        }

    }

    /**
     * 静态类方法
     */
    private synchronized static void syncStaticMethod() {
        System.out.println(Thread.currentThread().getName()+"_SyncStaticMethod_Enter_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncStaticMethod_Start_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_SyncStaticMethod_End_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 类同步代码块
     */
    private void syncClass() {
        System.out.println(Thread.currentThread().getName()+"_SyncClass_Enter_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (SyncThread.class){
            try {
                System.out.println(Thread.currentThread().getName()+"_SyncClass_Start_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"_SyncClass_End_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 非静态同步方法
     */
    private synchronized void syncMethod() {
        System.out.println(Thread.currentThread().getName()+"_SyncMethod_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncMethod_Start_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_SyncMethod_End_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步代码块
     */
    private void syncObject() {
        System.out.println(Thread.currentThread().getName()+"_SyncObject_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName()+"_SyncObject_Start_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"_SyncObject_End_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 非同步方法
     */
    private void asyncThread() {
        try {
            System.out.println(Thread.currentThread().getName()+"_Async_Start_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_Async_End_"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
