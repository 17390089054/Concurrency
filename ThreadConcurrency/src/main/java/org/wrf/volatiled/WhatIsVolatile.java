package org.wrf.volatiled;

import java.util.concurrent.TimeUnit;

/**
 * volatiled 基本用法<br>
 *
 * @className: WhatIsVolatile
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-02 21:02:47
 */
public class WhatIsVolatile {
    private volatile boolean running=true;
    void m(){
        System.out.println("m start");
        while(running){

        }
        System.out.println("m end");
    }


    public static void main(String[] args) {
        WhatIsVolatile v=new WhatIsVolatile();
        new Thread(v::m,"t").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.running=false;
    }

}
