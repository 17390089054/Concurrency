package org.wrf.tools;

import java.util.concurrent.TimeUnit;

/**
 * ReentrantLockDemo 重入锁<br>
 *
 * @className: ReentrantLockDemo
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 17:16:55
 */
public class ReentrantLockDemo {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if(i==2)
                m2();
        }
    }

    synchronized void m2() {
        System.out.println("m2....");
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo=new ReentrantLockDemo();
        new Thread(demo::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
