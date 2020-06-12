package org.wrf.thread;

/**
 * 〈功能概述〉<br>
 *
 * @className: WaitSleepDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 13:03:15
 */
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock=new Object();
        new Thread(() -> {
            System.out.println("Thread A is waiting to get lock!");
            synchronized (lock){
                try {
                    System.out.println("thread A get lock");
                    System.out.println("thread A do wait method");
                    //限时等待
                    //lock.wait(1000);
                    lock.wait();
                    System.out.println("thread A is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("Thread B is waiting to get lock!");
            synchronized (lock){
                try {
                    System.out.println("thread B get lock");
                    System.out.println("thread B is sleeping 10 ms");
                    Thread.sleep(10);
                    System.out.println("thread B is done");
                    //唤醒线程A
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
