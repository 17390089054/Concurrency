package org.wrf.huawei;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * 华为面试题 <br>
 * 两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 * 然后要让这两个线程做到同时运行，交替输出，顺序打印。
 * TransferQueue实现交替输出
 * @className: H10_TransferQueue
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 22:23:24
 */
public class H10_TransferQueue {
    public static void main(String[] args) {
        char []c1="123456".toCharArray();
        char []c2="ABCDEF".toCharArray();

        TransferQueue<Character> queue=new LinkedTransferQueue<>();
        new Thread(()->{
            for (char c : c1) {
                try {
                    System.out.println(queue.take());
                    queue.transfer(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (char c : c2) {
                try {
                    queue.transfer(c);
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"t2").start();

    }
}
