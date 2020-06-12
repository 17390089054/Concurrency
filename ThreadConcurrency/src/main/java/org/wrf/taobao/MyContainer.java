package org.wrf.taobao;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 淘宝面试题02<br>
 *  写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 *  能够支持2个生产者线程及10个消费者线程的阻塞调用。
 *  常规实现  wait()  notifyAll()
 * @className: MyContainer
 * @package: org.wrf.taobao
 * @author: knight
 * @date: 2020-05-23 14:31:56
 */
public class MyContainer<T>{
    final private LinkedList<T> lists=new LinkedList<>();
    final private int MAX=10;//最多10个元素
    private int count=0;
    //生产者
    public synchronized void put(T t){
        while(lists.size()==MAX){//使用while而非if
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        //唤醒所有的消费者线程
        this.notifyAll();
    }
    //消费者
    public synchronized T get(){
        T t=null;
        while(lists.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t=lists.removeFirst();
        count--;
        //唤醒所有生产者线程进行生产
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer<String>mc=new MyContainer<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(mc.get());
                }
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    mc.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }


    }


}
