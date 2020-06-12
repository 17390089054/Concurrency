package org.wrf.thread;

/**
 * 打印当前线程类 <br>
 *
 * @className: CuurentThreadDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 08:49:19
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        System.out.println("Current Thread :"+Thread.currentThread().getName());
    }
}
