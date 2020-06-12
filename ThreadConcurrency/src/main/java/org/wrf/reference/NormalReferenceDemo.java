package org.wrf.reference;

import java.io.IOException;

/**
 * 强引用 NormalReference <br>
 *
 * @className: NormalReference
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 22:26:22
 */
public class NormalReferenceDemo {
    public static void main(String[] args) throws IOException {
        M m=new M();
        m=null;
        System.gc();
        System.in.read();
    }
}
