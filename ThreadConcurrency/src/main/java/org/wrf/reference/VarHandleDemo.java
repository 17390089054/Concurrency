package org.wrf.reference;


/*import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;*/

/**
 * VarHandle原子自增，线程安全 <br>
 *
 * @className: VarHandleDemo
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 21:50:35
 */
public class VarHandleDemo {
  /*  int x=8;
    private static VarHandle handle;
    static{
        try {
            handle= MethodHandles.lookup().findVarHandle(VarHandleDemo.class,"x",int.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VarHandleDemo t=new VarHandleDemo();
        System.out.println((int)handle.get(t));
        handle.set(t,9);
        System.out.println(t.x);
        handle.compareAndSet(t,9,10);
        System.out.println(t.x);
        handle.getAndAdd(t,10);
        System.out.println(t.x);
    }*/
}
