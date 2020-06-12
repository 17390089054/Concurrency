package org.wrf.volatiled;

/**
 * Volatile可见性原理<br>
 *
 * @className: VolatileTest
 * @package: org.wrf.volatiled
 * @author: knight
 * @date: 2020-05-03 15:10:07
 */
public class VolatileTest {

    private static volatile VolatileTest instance = null;

    private VolatileTest(){}

    public static VolatileTest getInstance(){
        if(instance == null){
            instance = new VolatileTest();
        }

        return instance;
    }

    public static void main(String[] args) {
        VolatileTest.getInstance();
    }
}