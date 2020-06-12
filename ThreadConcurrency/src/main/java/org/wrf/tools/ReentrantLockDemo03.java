package org.wrf.tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock控制锁粒度 <br>
 *
 * @className: ReentrantLockDemo03
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 17:40:06
 */
public class ReentrantLockDemo03 {
    Lock lock=new ReentrantLock();

    void m1(){
            try {
                lock.lock();
                for (int i = 0; i < 3; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }

    /**
     * 使用tryLock尝试锁定，不管锁定与否，方法都继续执行
     * 可以根据tryLock的返回值来判断是否锁定
     * 也可以指定tryLock的时间
     */
    void m2(){
        boolean locked=false;
        try{
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2...."+locked);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(locked)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo03 demo=new ReentrantLockDemo03();
        new Thread(demo::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo::m2).start();
    }


}
