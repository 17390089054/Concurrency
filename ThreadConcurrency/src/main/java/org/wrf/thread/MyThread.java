package org.wrf.thread;

/**
 * 〈功能概述〉<br>
 *
 * @className: MyThread
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 09:50:09
 */
public class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start :"+this.name+" i="+i);
        }
    }
}
