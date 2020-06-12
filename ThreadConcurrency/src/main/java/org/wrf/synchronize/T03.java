package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T03
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 09:49:35
 */
public class T03 {
    private int count=10;
    //锁对象
    public synchronized void m(){
        count--;
        System.out.println(Thread.currentThread().getName()+" count= "+count);
    }

}
