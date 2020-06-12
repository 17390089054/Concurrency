package org.wrf.volatiled;


import java.util.concurrent.TimeUnit;

/**
 *  对象锁<br>
 *
 * @className: T02
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 10:46:48
 */
public class T02 {
    Object o=new Object();
    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T02 t=new T02();
        //启动一个线程
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2=new Thread(t::m,"t2");
        t.o=new Object();
        t2.start();
    }

}
