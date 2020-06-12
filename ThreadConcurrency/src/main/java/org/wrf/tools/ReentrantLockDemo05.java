package org.wrf.tools;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 公平锁<br>
 *
 * @className: ReentrantLockDemo05
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 18:02:57
 */
public class ReentrantLockDemo05 extends Thread{
    private static ReentrantLock lock=new ReentrantLock(true);
    public void run(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
          try{
            System.out.println(Thread.currentThread().getName()+"获得锁");
          }finally {
              lock.unlock();
          }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo05 demo=new ReentrantLockDemo05();
        new Thread(demo).start();
        new Thread(demo).start();

    }
}
