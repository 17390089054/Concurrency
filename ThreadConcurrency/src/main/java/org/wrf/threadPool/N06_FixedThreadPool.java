package org.wrf.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池实现并行计算 <br>
 *
 * @className: N06_FixedThreadPool
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 09:27:33
 */
public class N06_FixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start,end;
        start=System.currentTimeMillis();
        getPrime(1,200000);
        end = System.currentTimeMillis();
        System.out.println("main thread time costs :"+(end-start));

        //核心线程数
        final int coreNum=4;
        ExecutorService service = Executors.newFixedThreadPool(coreNum);
        MyTask t1=new MyTask(1,80000);
        MyTask t2=new MyTask(80001,130000);
        MyTask t3=new MyTask(130001,170000);
        MyTask t4=new MyTask(170001,200000);
        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println("ThreadPool Time Costs :"+(end-start));

    }
    static class MyTask implements Callable<List<Integer>>{
        int startPos,endPos;

        public MyTask(int s,int e){
            this.startPos=s;
            this.endPos=e;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> result=getPrime(startPos,endPos);
            return result;
        }
    }

    static List<Integer> getPrime(int startPos, int endPos) {
        List<Integer> results=new ArrayList<>();
        for (int i = startPos; i <= endPos; i++) {
            if(isPrime(i))
                results.add(i);
        }
        return results;
    }

    static boolean isPrime(int num) {
        for (int j = 2; j <= num/2 ; j++) {
            if(num%j==0) return false;
        }
        return true;
    }

}
