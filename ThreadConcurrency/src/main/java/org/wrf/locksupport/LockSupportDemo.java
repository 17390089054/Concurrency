package org.wrf.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport基本使用 <br>
 *
 * @className: LockSupportDemo
 * @package: org.wrf.locksupport
 * @author: knight
 * @date: 2020-05-23 11:07:18
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        //使用lambda表达式创建一个线程t
        Thread t=new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i==5){
                    //使用LockSupport的park()方法阻塞当前线程t
                    LockSupport.park();
                }
            }
        });
        t.start();
        LockSupport.unpark(t);
    }
}
