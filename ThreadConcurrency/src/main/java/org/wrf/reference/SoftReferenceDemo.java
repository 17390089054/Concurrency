package org.wrf.reference;

import java.lang.ref.SoftReference;

/**
 *  软引用 SoftReference <br>
 *
 * @className: SoftReferenceDemo
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 22:59:12
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        SoftReference<byte[]> m=new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        byte [] b=new byte[1024*1024*15];
        System.out.println(m.get());
    }
}
