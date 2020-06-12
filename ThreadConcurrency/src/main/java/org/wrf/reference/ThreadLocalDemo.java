package org.wrf.reference;


import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程本地变量 不使用ThreadLocal<br>
 *
 * @className: ThreadLocalDemo
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 22:02:30
 */
public class ThreadLocalDemo {
    volatile static Person person=new Person();
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(person.name);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.name="lisi";
        }).start();
    }

    static class Person{
        String name="zhangsan";
    }
}
