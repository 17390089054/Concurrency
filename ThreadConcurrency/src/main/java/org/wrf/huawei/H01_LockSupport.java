package org.wrf.huawei;

import java.util.concurrent.locks.LockSupport;

/**
 * 华为面试题<br>
 *  两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 *  然后要让这两个线程做到同时运行，交替输出，顺序打印。
 *  LockSupport实现阻塞与唤醒
 * @className: H01_LockSupport
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 19:38:21
 */
public class H01_LockSupport {
    static Thread t1=null,t2=null;
    public static void main(String[] args) {
        char []c1="123456".toCharArray();
        char []c2="ABCDEF".toCharArray();
        t1=new Thread(()->{
            for (char c : c1) {
                System.out.println(c);
                //唤醒t2
                LockSupport.unpark(t2);
                //阻塞t1
                LockSupport.park();
            }

        },"t1");

        t2=new Thread(()->{
            for (char c : c2) {
                //阻塞t2
                LockSupport.park();
                System.out.println(c);
                //唤醒t1
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();


    }
}
