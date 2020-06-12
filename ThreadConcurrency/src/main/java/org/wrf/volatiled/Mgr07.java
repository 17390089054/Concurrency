package org.wrf.volatiled;

import java.util.concurrent.TimeUnit;

/**
 * 双重检测 double check <br>
 *
 * @className: Mgr06
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 09:54:41
 */
public class Mgr07 {
    //防止指令重排序
    private volatile static Mgr07 INSTANCE;
    private Mgr07(){}

    public static Mgr07 getInstance(){
        if(INSTANCE==null){
            synchronized (Mgr07.class){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(INSTANCE==null){
                    INSTANCE=new Mgr07();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr07.getInstance().hashCode())).start();
        }
    }
}
