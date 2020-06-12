package org.wrf.atomic;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 多种线程运行方式对比<br>
 *
 * @className: AtomicVsSynchronizedVsLongAdder
 * @package: org.wrf.atomic
 * @author: knight
 * @date: 2020-05-22 16:31:23
 */
public class AtomicVsSynchronizedVsLongAdder {
    static AtomicLong count1=new AtomicLong(0L);
    static long count2=0L;
    static LongAdder count3=new LongAdder();
    public static void main(String[] args) throws InterruptedException {
        //AtomicLong方式实现自增
        Thread [] threads=new Thread[1000];
        for (int i = 0; i <threads.length; i++) {
            threads[i]=new Thread(() -> {
                for (int j = 0; j < 100000;j++) {
                    count1.incrementAndGet();
                }
            });
        }
        long start=System.currentTimeMillis();
        for (Thread t: threads){
            t.start();
        }
        for (Thread t:threads){
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("AtomicLong:"+count1.get()+" time:"+(end-start));
        System.out.println("==============================");
        //Synchronized方式实现自增
        Object lock=new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    synchronized (lock){
                        count2++;
                    }
                }
            });
        }
        start=System.currentTimeMillis();
        for (Thread t:threads){
            t.start();
        }
        for (Thread t:threads){
            t.join();
        }
        end=System.currentTimeMillis();
        System.out.println("Sync:"+count2+" time:"+(end-start));
        System.out.println("==============================");
        //LongAdder实现自增
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            });
        }
        start=System.currentTimeMillis();
        for (Thread t:threads){
            t.start();
        }
        for (Thread t:threads){
            t.join();
        }
        end=System.currentTimeMillis();
        System.out.println("LongAdder:"+count3+" time:"+(end-start));

    }

    static void microSleep(int m){
        try {
            TimeUnit.MICROSECONDS.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
