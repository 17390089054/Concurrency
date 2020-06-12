package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T05
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 10:03:25
 */
public class T05 implements Runnable {
    private int count=100;

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+" count= "+count);
    }

    public static void main(String[] args) {
        T05 t=new T05();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"THREAD"+i).start();
        }
    }
}
