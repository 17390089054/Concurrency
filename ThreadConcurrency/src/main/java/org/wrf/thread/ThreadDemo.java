package org.wrf.thread;

/**
 * ThreadDemo <br>
 *
 * @className: ThreadDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 09:52:22
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread m1=new MyThread("m1");
        MyThread m2=new MyThread("m2");
        MyThread m3=new MyThread("m3");
        m1.start();
        m2.start();
        m3.start();

    }
}
