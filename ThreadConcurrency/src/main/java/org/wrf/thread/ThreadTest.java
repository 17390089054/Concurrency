package org.wrf.thread;

/**
 * run方法与start方法对比 <br>
 *
 * @className: ThreadTest
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 09:05:00
 */
public class ThreadTest {
    private static void attack(){
        System.out.println("Fight");
        System.out.println("Current Thread is :"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                attack();
            }
        });
        System.out.println("Current main thread is: "+Thread.currentThread().getName());
        //t.run();
        t.start();
    }

}
