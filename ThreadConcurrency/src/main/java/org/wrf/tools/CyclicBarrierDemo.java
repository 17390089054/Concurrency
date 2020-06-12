package org.wrf.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏 CyclicBarrier 用法<br>
 *
 * @className: CyclicBarrierDemo
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 21:35:54
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(20, () -> System.out.println("满人，发车"));
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
