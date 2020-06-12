package org.wrf.huawei;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 华为面试题<br>
 *  两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 *  然后要让这两个线程做到同时运行，交替输出，顺序打印。
 *  ReentrantLock Condition实现线程交替输出
 * @className: H01_LockSupport
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 19:38:21
 */
public class H05_Lock_Condition {
    static Thread t1=null,t2=null;
    public static void main(String[] args) {
        char []c1="123456".toCharArray();
        char []c2="ABCDEF".toCharArray();

        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();

        new Thread(()->{
                try {
                    lock.lock();
                    for (char c : c1) {
                        System.out.println(c);
                        condition.signal();
                        condition.await();
                     }
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
        },"t1").start();

        new Thread(()->{
            try{
                lock.lock();
                for (char c : c2) {
                    System.out.println(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2").start();


    }
}
