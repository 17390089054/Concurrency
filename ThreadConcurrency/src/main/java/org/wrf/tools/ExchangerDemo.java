package org.wrf.tools;

import java.util.concurrent.Exchanger;

/**
 * 交换器 Exchanger <br>
 *
 * @className: Exchanger
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 23:05:37
 */
public class ExchangerDemo {
    static Exchanger<String> exchanger=new Exchanger<>();
    public static void main(String[] args) {
        new Thread(()->{
            String s="T1";
            try {
                s=exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+s);
        },"t1").start();

        new Thread(()->{
            String s="T2";
            try {
                s=exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+s);
        },"t2").start();


    }
}
