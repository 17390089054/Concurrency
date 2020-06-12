package org.wrf.huawei;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 华为面试题 <br>
 * 两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 *  然后要让这两个线程做到同时运行，交替输出，顺序打印。
 *  ArrayBlockingQueue实现阻塞与释放操作
 * @className: H08_BlockingQueue
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 21:39:19
 */
public class H08_BlockingQueue {
    static BlockingQueue<String> q1=new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2=new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        char []c1="123456".toCharArray();
        char []c2="ABCDEF".toCharArray();

        new Thread(()->{
            for (char c : c1) {
                System.out.println(c);
                try {
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (char c : c2) {
                try {
                    q1.take();
                    System.out.println(c);
                    q2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

    }
}
