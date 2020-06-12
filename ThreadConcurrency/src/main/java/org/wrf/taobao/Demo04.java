package org.wrf.taobao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 淘宝面试题 <br>
 *   实现一个容器，提供两个方法add、size，写两个线程：
 *   线程1，添加10个元素到容器中
 *   线程2，实时监控元素个数，当个数到5个时，线程2给出提示并结束
 *   wait(),notify()改进版--成功
 * @className: Demo
 * @package: org.wrf.taobao
 * @author: knight
 * @date: 2020-05-23 12:52:15
 */
public class Demo04 {
    volatile List<Object> list=new ArrayList<>();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Demo04 demo=new Demo04();
        final Object lock=new Object();
        //先启动t2再启动t1
        new Thread(() -> {
            synchronized (lock){
                System.out.println("t2 启动");
                if(demo.size()!=5){
                    try {
                        //阻塞当前线程t1
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 结束");
                }
                //唤醒线程t1
                lock.notify();
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(() -> {
            System.out.println("t1 启动");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    demo.add(new Object());
                    System.out.println("add "+i);
                    if(demo.size()==5){
                        //唤醒t2
                        lock.notify();
                        try {
                            //释放锁,阻塞当前线程
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"t1").start();
    }


}
