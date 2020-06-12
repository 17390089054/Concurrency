package org.wrf.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo <br>
 *
 * @className: CyclicBarrierDemo
 * @package: org.wrf.juc
 * @author: knight
 * @date: 2020-05-15 21:43:30
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierDemo().go();
    }

    private void go() throws InterruptedException {
        //初始化栅栏参与者为3
        CyclicBarrier barrier=new CyclicBarrier(3);
        //依次创建3个线程
        new Thread(new Task(barrier),"Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(barrier),"Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(barrier),"Thread3").start();
        Thread.sleep(1000);
        System.out.println("线程 "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
    }

    class Task implements Runnable{
        private CyclicBarrier barrier;
        public Task(CyclicBarrier barrier){
            this.barrier=barrier;
        }
        @Override
        public void run() {
            try {
                System.out.println("线程 "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
