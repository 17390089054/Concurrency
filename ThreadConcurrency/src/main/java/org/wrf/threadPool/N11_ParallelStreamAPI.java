package org.wrf.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 并行流式处理API <br>
 *
 * @className: N11_ParallelStreamAPI
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 11:34:34
 */
public class N11_ParallelStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000+r.nextInt(1000000));
        }
        //forEach流式处理
        long start=System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end=System.currentTimeMillis();
        System.out.println("forEach:"+(end-start));

        start=System.currentTimeMillis();
        nums.parallelStream().forEach(N11_ParallelStreamAPI::isPrime);
        end=System.currentTimeMillis();
        System.out.println("parallelStream:"+(end-start));
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num/2 ; i++) {
            if(num %i==0)
                return false;
        }
        return true;
    }
}
