package org.wrf.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 异常锁 <br>
 *
 * @className: T11
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 11:35:35
 */
public class T11 {
    int count=0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+" count="+count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==5){
                //制造异常
                int i=1/0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T11 t=new T11();
        Runnable r= () -> t.m();
        new Thread(r,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"t2").start();
    }

}
