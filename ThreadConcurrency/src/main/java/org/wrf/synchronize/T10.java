package org.wrf.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 〈功能概述〉<br>
 *
 * @className: T10
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 11:24:12
 */
public class T10 {
    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T10{
    @Override
    synchronized  void m(){
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }

}