package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T04
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 09:52:22
 */
public class T04 {
    private static int count=10;
    //等同于synchronized(T.class)
    public synchronized static void m(){
        count--;
        System.out.println(Thread.currentThread().getName()+" count= "+count);
    }

    public static void mm(){
        synchronized (T04.class){//synchronized(T.class)
            count--;
            System.out.println(Thread.currentThread().getName()+" count= "+count);
        }
    }

}
