package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T06
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 10:07:19
 */
public class T06 implements Runnable{
    private static int count=10;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            T06 t=new T06();
            new Thread(t,"thread"+i).start();
        }
    }

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+" count= "+count);
    }
}
