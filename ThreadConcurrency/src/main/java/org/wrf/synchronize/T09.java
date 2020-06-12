package org.wrf.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 重入锁<br>
 *
 * @className: T09
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 11:16:02
 */
public class T09 {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m3 end");
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        new T09().m1();
    }
}
