package org.wrf.taobao;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 淘宝面试题02<br>
 *  写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 *  能够支持2个生产者线程及10个消费者线程的阻塞调用。
 *
 * @className: MyContainer
 * @package: org.wrf.taobao
 * @author: knight
 * @date: 2020-05-23 14:31:56
 */
public class MyContainer02<T>{
    final private LinkedList<T> lists=new LinkedList<>();
    final private int MAX=10;//最多10个元素
    private int count=0;
    private Lock lock=new ReentrantLock();
    private Condition consumer=lock.newCondition();
    private Condition producer=lock.newCondition();

    //生产者
    public  void put(T t){
            try {
                lock.lock();
                while(lists.size()==MAX){//使用while而非if
                    producer.await();
                }
                lists.add(t);
                ++count;
                //通知所有的消费者线程进行消费
                consumer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

    }
    //消费者
    public  T get(){
        T t=null;
        try {
            lock.lock();
            while(lists.size()==0){
                consumer.await();
            }
            t=lists.removeFirst();
            count--;
            //唤醒所有生产者线程进行生产
            producer.signalAll();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer02<String> mc=new MyContainer02<>();
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
