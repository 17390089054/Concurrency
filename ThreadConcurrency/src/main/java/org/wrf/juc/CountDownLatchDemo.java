package org.wrf.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo <br>
 *
 * @className: CountDownLatchDemo
 * @package: org.wrf.juc
 * @author: knight
 * @date: 2020-05-15 21:12:35
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }
    private void go() throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        //创建3个线程
        new Thread(new MyTask(latch),"Thread1").start();
        Thread.sleep(1000);
        new Thread(new MyTask(latch),"Thread2").start();
        Thread.sleep(1000);
        new Thread(new MyTask(latch),"Thread3").start();
        latch.await();
        System.out.println("所有线程已到达，主线程开始执行 "+System.currentTimeMillis());
    }

    class MyTask implements Runnable{
        private CountDownLatch latch;
        public MyTask(CountDownLatch latch){
            this.latch=latch;
        }
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+" 已经到达 "+System.currentTimeMillis());
            latch.countDown();
        }
    }


}
