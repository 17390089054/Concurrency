package org.wrf.tools;

import java.util.concurrent.CountDownLatch;

/**
 * 倒数门栓 CountDownLatch用法 <br>
 *
 * @className: CountDownLatchDemo
 * @package: org.wrf.tools
 * @author: knight
 * @date: 2020-05-22 21:22:02
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        usingJoin();
        usingCountDownLatch();
    }

    private static void usingCountDownLatch(){
        Thread [] threads=new Thread[100];
        CountDownLatch latch=new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(() -> {
                int result=0;
                for (int j = 0; j < 10000; j++)
                    result+=j;
                latch.countDown();
              //  System.out.println(result);
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");
    }

    private static void usingJoin(){
        Thread [] threads=new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    int result=0;
                    for (int j = 0; j < 10000; j++) {
                        result+=j;
                    }
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end join");
    }

}
