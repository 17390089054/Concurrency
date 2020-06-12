package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T08
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 10:54:24
 */
public class T08 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start.....");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end ");
    }

    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 ");
    }

    public static void main(String[] args) {
        T08 t=new T08();
        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();

    }

}
