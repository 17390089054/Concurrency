package org.wrf.synchronize;

/**
 * 〈功能概述〉<br>
 *
 * @className: T
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 09:43:30
 */
public class T01 {
    private int count=10;
    private final Object o=new Object();

    /**
     * 锁定object
     */
    public void m(){
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+" count= "+count);
        }
    }

}
