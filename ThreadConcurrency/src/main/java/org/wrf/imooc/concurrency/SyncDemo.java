package org.wrf.imooc.concurrency;

/**
 * sync方法测试 <br>
 *
 * @className: SyncDemo
 * @package: org.wrf.imooc.concurrency
 * @author: knight
 * @date: 2020-05-09 23:37:51
 */
public class SyncDemo {
    public static void main(String[] args) {
        SyncThread st=new SyncThread();
        Thread t1=new Thread(st,"A1");
        Thread t2=new Thread(st,"A2");
        Thread t3=new Thread(st,"B1");
        Thread t4=new Thread(st,"B2");
        Thread t5=new Thread(st,"C1");
        Thread t6=new Thread(st,"C2");
        Thread t7=new Thread(st,"D1");
        Thread t8=new Thread(st,"D2");
        Thread t9=new Thread(st,"E1");
        Thread t10=new Thread(st,"E2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }
}
