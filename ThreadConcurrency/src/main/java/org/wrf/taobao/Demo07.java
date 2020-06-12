package org.wrf.taobao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 淘宝面试题 <br>
 *   实现一个容器，提供两个方法add、size，写两个线程：
 *   线程1，添加10个元素到容器中
 *   线程2，实时监控元素个数，当个数到5个时，线程2给出提示并结束
 *   LockSupport--成功
 * @className: Demo
 * @package: org.wrf.taobao
 * @author: knight
 * @date: 2020-05-23 12:52:15
 */
public class Demo07 {
    //添加volatile，使t2能够得到通知
    volatile List<Object> list=new ArrayList<>();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    static Thread t1=null,t2=null;
    public static void main(String[] args) {
        Demo07 demo=new Demo07();
        t2=new Thread(() -> {
            System.out.println("t2 启动");
            if(demo.size()!=5){
                LockSupport.park();
            }
            System.out.println("t2 结束");
            //唤醒t1，以继续执行
            LockSupport.unpark(t1);
        },"t2");
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1=new Thread(() -> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                demo.add(new Object());
                System.out.println("add "+i);
                if(demo.size()==5){
                    LockSupport.unpark(t2);
                    //阻塞t1，防止往下执行
                    LockSupport.park();
                }
               /* try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

        },"t1");
        t1.start();
    }


}
