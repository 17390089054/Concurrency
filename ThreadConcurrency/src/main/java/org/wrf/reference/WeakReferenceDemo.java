package org.wrf.reference;

import java.lang.ref.WeakReference;

/**
 * 虚引用WeakReference <br>
 *
 * @className: WeakReferenceDemo
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 23:05:14
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        WeakReference<M> m=new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        ThreadLocal<M> t=new ThreadLocal<>();
        t.set(new M());
        t.remove();
    }
}
