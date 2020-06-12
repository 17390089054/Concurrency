package org.wrf.volatiled;

/**
 * Volatile 实现线程安全示例<br>
 *
 * @className: VolatileSafe
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-14 12:04:34
 */
public class VolatileSafe {
    volatile boolean shutdown;
    public void close(){
        shutdown=true;
    }

    public void doWork(){
        while (!shutdown){
            System.out.println("safe......");
        }
    }
    public static void main(String[] args) {

    }
}
