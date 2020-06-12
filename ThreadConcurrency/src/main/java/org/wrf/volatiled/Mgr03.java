package org.wrf.volatiled;

/**
 * 非线程安全懒汉式<br>
 *
 * @className: Mgr03
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 09:29:43
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;
    private Mgr03(){}

    public static Mgr03 getInstance(){
        if(INSTANCE==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Mgr03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr03 m1=Mgr03.getInstance();
        Mgr03 m2=Mgr03.getInstance();
        System.out.println(m1==m2);
    }


}
