package org.wrf.volatiled;

import java.util.concurrent.TimeUnit;

/**
 * 锁细化 <br>
 *
 * @className: FineCoarseLock
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 10:40:14
 */
public class FineCoarseLock {
    int count=0;
    //锁整个方法
    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //锁一个语句 锁细化
    void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
