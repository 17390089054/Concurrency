package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T02
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 09:47:26
 */
public class T02 {
    private int count=10;
    //锁对象
    public void m(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+" count= "+count);
        }
    }
}
