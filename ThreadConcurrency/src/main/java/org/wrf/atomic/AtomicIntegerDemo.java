package org.wrf.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerDemo<br>
 *
 * @className: AtomicInteger
 * @package: org.wrf.atomic
 * @author: knight
 * @date: 2020-05-22 16:07:29
 */
public class AtomicIntegerDemo {
    AtomicInteger count=new AtomicInteger();
    void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerDemo demo=new AtomicIntegerDemo();
        List<Thread> threads= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(demo::m, "Thread-" + i));
        }

        threads.forEach(Thread::start);
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(demo.count);
    }



}
