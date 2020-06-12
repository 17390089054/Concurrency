package org.wrf.volatiled;

import java.util.concurrent.TimeUnit;

/**
 *  锁细化 <br>
 *
 * @className: Mgr05
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 09:48:18
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05(){}

    public static Mgr05 getInstance(){
        //线程不安全
        if(INSTANCE==null){
            synchronized (Mgr05.class){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE=new Mgr05();
            }
        }
        return INSTANCE;
    }
    public static void main(String[] args) {

    }
}
