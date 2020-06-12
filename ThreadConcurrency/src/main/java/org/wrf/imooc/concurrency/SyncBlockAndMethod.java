package org.wrf.imooc.concurrency;

/**
 * 同步代码块和同步方法<br>
 *
 * @className: SyncBlockAndMethod
 * @package: org.wrf.imooc.concurrency
 * @author: knight
 * @date: 2020-05-14 10:42:19
 */
public class SyncBlockAndMethod {
    public void lockObject(){
        synchronized (this){
            System.out.println("Hello Object");
        }
    }

    public synchronized void lockMethod(){
        System.out.println("Hello methods");
        synchronized (this){
            System.out.println("可重入锁");
        }
    }

    public static void main(String[] args) {
        System.out.println("main");
    }


}
