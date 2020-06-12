package org.wrf.huawei;

import java.util.concurrent.CountDownLatch;

/**
 * 华为面试题<br>
 *   两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 *   然后要让这两个线程做到同时运行，交替输出，顺序打印。
 *   CountDownLatch实现交替输出
 * @className: H04_CountDownLatch
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 20:23:47
 */
public class H04_CountDownLatch {
    private static CountDownLatch latch=new CountDownLatch(1);
    public static void main(String[] args) {
        char []c1="123456".toCharArray();
        char []c2="ABCDEF".toCharArray();
        final Object o=new Object();
        new Thread(()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                for (char c : c1) {
                        System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized (o){
                for (char c : c2) {
                    System.out.println(c);
                    latch.countDown();
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2").start();
    }
}
