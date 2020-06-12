package org.wrf.reference;

/**
 * 重写finalize()方法 <br>
 *
 * @className: M
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 22:25:06
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
