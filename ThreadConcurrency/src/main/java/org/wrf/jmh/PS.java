package org.wrf.jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * JMH demo 微基准测试单元 <br>
 *
 * @className: PS
 * @package: org.wrf.jmh
 * @author: knight
 * @date: 2020-06-06 17:05:10
 */
public class PS {
    static List<Integer> nums=new ArrayList<>();
    static {
        Random r=new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000+r.nextInt(1000000));
        }
    }

    static void foreach(){
        nums.forEach(v->isPrime(v));
    }

    static void parallel(){
        nums.parallelStream().forEach(PS::isPrime);
    }

    static boolean isPrime(Integer v) {
        for (int i = 2; i <= v/2 ; i++) {
            if(v%i==0)
                return false;
        }
        return true;
    }
}
