package org.wrf.thread;


/**
 * Yield 基本用法 <br>
 * Thread.yield() 通知调度器scheduler让出CPU使用权，是否让出由调度器scheduler决定
 * Thread.yield() 对锁的行为无影响，即不让出持有的锁
 * @className: YieldDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 14:02:35
 */
public class YieldDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable yield=new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                    if(i==5){
                        Thread.yield();
                    }
                }
            }
        };
        Thread t1=new Thread(yield,"A");
        Thread t2=new Thread(yield,"B");
        t1.start();
        t2.start();
    }
}
