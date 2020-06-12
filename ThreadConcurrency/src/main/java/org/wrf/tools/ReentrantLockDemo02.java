package org.wrf.tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock用法<br>
 *
 * @className: ReentrantLockDemo02
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 17:33:02
 */
public class ReentrantLockDemo02 {
    Lock lock=new ReentrantLock();

    void m1(){
        try{
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        try{
            lock.lock();
            System.out.println("m2......");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo02 demo02=new ReentrantLockDemo02();
        new Thread(demo02::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo02::m2).start();
    }

}
