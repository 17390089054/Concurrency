package org.wrf.thread;

/**
 * 〈功能概述〉<br>
 *
 * @className: MyRunnable
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 09:54:14
 */
public class MyRunnable implements Runnable {
    private  String name;
    public MyRunnable(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start: "+this.name+" i="+i);
        }
    }
}
