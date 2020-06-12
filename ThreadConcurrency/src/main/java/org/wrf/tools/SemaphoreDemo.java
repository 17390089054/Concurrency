package org.wrf.tools;

import java.util.concurrent.Semaphore;

/**
 * 信号量 Semaphore <br>
 *
 * @className: SemaphoreDemo
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 22:59:36
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //允许2个线程，公平锁
        Semaphore s=new Semaphore(2,true);
        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
