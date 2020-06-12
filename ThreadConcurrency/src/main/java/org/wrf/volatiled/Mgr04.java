package org.wrf.volatiled;

import java.util.concurrent.TimeUnit;

/**
 * 线程安全式懒汉式 <br>
 *
 * @className: Mgr04
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 09:41:32
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04(){}
    public static synchronized Mgr04 getInstance(){
        if(INSTANCE==null){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
