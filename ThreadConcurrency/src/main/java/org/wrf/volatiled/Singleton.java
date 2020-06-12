package org.wrf.volatiled;

/**
 * volatile 实现单例模式 <br>
 *
 * @className: Singleton
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-14 12:09:07
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null){
           synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
           }
        }
        return instance;
    }

}
