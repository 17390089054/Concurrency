package org.wrf.thread;

import org.wrf.volatiled.T;

/**
 *  notify()与notifyAll()区别 <br>
 *  notify()        随机唤醒一个等待池中的线程进入锁池
 *  notifyAll()     唤醒等待池中的所有线程进入锁池
 * @className: NotificationDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 13:23:57
 */
public class NotificationDemo {
    private volatile boolean go=false;
    public static void main(String[] args) throws InterruptedException {
        NotificationDemo test=new NotificationDemo();
        Runnable waitTask= () -> {
            try {
                test.shouldGo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" finish execution");
        };

        Runnable notifyTask= () -> {
            test.go();
            System.out.println(Thread.currentThread().getName()+" finish execution");
        };

        Thread t1=new Thread(waitTask,"WT1");
        Thread t2=new Thread(waitTask,"WT2");
        Thread t3=new Thread(waitTask,"WT3");

        Thread t4=new Thread(notifyTask,"WN1");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(200);

        t4.start();
    }

    private synchronized void shouldGo() throws InterruptedException {
        while (!go){
            System.out.println(Thread.currentThread()+" is going to wait on this object!");
            wait();
            System.out.println(Thread.currentThread()+" is woken up!");
        }
        go=false;
    }

    private synchronized void go(){
        while (!go){
            System.out.println(Thread.currentThread()+" is going to notifyAll or one thread waiting on this object");
            go=true;
            //notify();
            notifyAll();
        }
    }
}
