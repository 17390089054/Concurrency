package org.wrf.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  原子类 <br>
 *
 * @className: AtomicInteger
 * @package: org.wrf.cas
 * @author: knight
 * @date: 2020-05-03 10:57:37
 */
public class AtomicIntegerDemo {
    AtomicInteger count=new AtomicInteger();
    void m(){
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerDemo t=new AtomicIntegerDemo();
        List<Thread>threads=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"Thread-"+i));
        }
        threads.forEach(Thread::start);
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }

}
