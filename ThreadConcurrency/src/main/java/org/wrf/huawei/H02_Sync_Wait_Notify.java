package org.wrf.huawei;

/**
 *  华为面试题<br>
 *    两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 *    然后要让这两个线程做到同时运行，交替输出，顺序打印。
 *  Wait_Notify实现交替输出，最后记得notify唤醒线程
 * @className: H02_Sync_Wait_Notify
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 19:49:51
 */
public class H02_Sync_Wait_Notify {
    public static void main(String[] args) {
        char [] c1="123456".toCharArray();
        char [] c2="ABCDEF".toCharArray();
        final Object o=new Object();
        new Thread(()->{
            synchronized (o){
                for (char c : c1) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized (o){
                for (char c : c2) {
                    try {
                        System.out.println(c);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2").start();




    }
}
