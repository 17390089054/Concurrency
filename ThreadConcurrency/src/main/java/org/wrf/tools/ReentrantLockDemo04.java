package org.wrf.tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.lockInterruptibly()用法 <br>
 *
 * @className: ReentrantLockDemo04
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 17:52:26
 */
public class ReentrantLockDemo04 {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();

        Thread t1=new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start...");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2=new Thread(() -> {
            try {
                //可以对interrupt()方法做出响应
                lock.lockInterruptibly();
                System.out.println("t2 start...");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打断线程2的等待
        t2.interrupt();

    }
}
