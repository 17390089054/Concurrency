package org.wrf.volatiled;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile可见性问题 <br>
 * volatile 可见性保证
 * https://blog.csdn.net/reliveIT/article/details/50450136
 * @className: T
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 10:23:25
 */
public class T {
    volatile static int count=0;

    synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T t=new T();
        List<Thread> threads=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
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
}
