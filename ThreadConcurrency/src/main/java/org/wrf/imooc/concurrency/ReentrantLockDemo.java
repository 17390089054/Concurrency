package org.wrf.imooc.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo<br>
 *
 * @className: ReentrentLockDemo
 * @package: org.wrf.imooc.concurrency
 * @author: knight
 * @date: 2020-05-14 11:28:04
 */
public class ReentrantLockDemo implements Runnable{
    private static ReentrantLock lock=new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get lock!!!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo=new ReentrantLockDemo();
        Thread t1=new Thread(demo,"t1");
        Thread t2=new Thread(demo,"t2");
        t1.start();
        t2.start();
    }
}
