package org.wrf.volatiled;

/**
 * 饿汉式 DCL <br>
 *
 * @className: Mgr01
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 09:16:33
 */
public class Mgr01 {
    //静态实例对象
    private static final Mgr01 INSTANCE=new Mgr01();
    //私有化构造方法
    private Mgr01(){}
    //公有静态获取实例方法
    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1=Mgr01.getInstance();
        Mgr01 m2=Mgr01.getInstance();
        System.out.println(m1==m2);
    }

}
