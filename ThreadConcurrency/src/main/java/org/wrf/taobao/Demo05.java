package org.wrf.taobao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 淘宝面试题 <br>
 *   实现一个容器，提供两个方法add、size，写两个线程：
 *   线程1，添加10个元素到容器中
 *   线程2，实时监控元素个数，当个数到5个时，线程2给出提示并结束
 *   CountDownLatch--部分成功（t1不休眠失败）
 * @className: Demo
 * @package: org.wrf.taobao
 * @author: knight
 * @date: 2020-05-23 12:52:15
 */
public class Demo05 {
    volatile List<Object> list=new ArrayList<>();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Demo05 demo=new Demo05();
        CountDownLatch latch=new CountDownLatch(1);
        //先启动t2再启动t1
        new Thread(() -> {
            System.out.println("t2 启动");
            if(demo.size()!=5){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(() -> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                demo.add(new Object());
                System.out.println("add "+i);
                if(demo.size()==5){
                    latch.countDown();
                }
              /*  try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        },"t1").start();
    }


}
