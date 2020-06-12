package org.wrf.thread;

/**
 * Runnable Demo<br>
 *
 * @className: RunnableDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 09:55:25
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable m1=new MyRunnable("m1");
        MyRunnable m2=new MyRunnable("m2");
        MyRunnable m3=new MyRunnable("m3");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();

    }
}
