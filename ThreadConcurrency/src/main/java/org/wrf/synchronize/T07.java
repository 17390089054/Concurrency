package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T07
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 10:23:51
 */
public class T07 implements Runnable {
    private volatile static int count=10;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            T07 t=new T07();
            new Thread(t,"THREAD"+i).start();
        }
    }

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+" count= "+count);
    }
}
