package org.wrf.threadPool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool基本用法 <br>
 *
 * @className: N10_ForkJoinPool
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 11:18:55
 */
public class N10_ForkJoinPool {
    static int [] nums=new int [1000000];
    static final int MAX_NUM=50000;
    static Random r=new Random();

    static{
        for (int i = 0; i < nums.length; i++) {
            nums[i]=r.nextInt(100);
        }
        System.out.println("---"+ Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction{
        int start,end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if(end-start <= MAX_NUM){
                long sum=0L;
                for (int i = start; i < end; i++) {
                    sum+=nums[i];
                }
                System.out.println("from:"+start+" to:"+end+" ="+sum);
            }else{
                int middle=start+(end-start)/2;
                AddTask addTask1=new AddTask(start,middle);
                AddTask addTask2=new AddTask(middle+1,end);
                addTask1.fork();
                addTask2.fork();
            }
        }
    }

    static class AddTaskRet extends RecursiveTask<Long>{
        int start,end;

        public AddTaskRet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if(end-start <=MAX_NUM){
                long sum=0L;
                for (int i = start; i < end; i++)
                    sum+=nums[i];
                return sum;
            }

            int middle=start+(end-start)/2;

            AddTaskRet subTask1=new AddTaskRet(start,middle);
            AddTaskRet subTask2=new AddTaskRet(middle+1,end);
            subTask1.fork();
            subTask2.fork();
            return subTask1.join()+subTask2.join();
        }
    }

    public static void main(String[] args) {
        //使用方式一
      /*  ForkJoinPool pool=new ForkJoinPool();
        AddTask task=new AddTask(0,nums.length);
        pool.execute(task);*/


        ForkJoinPool forkJoinPool=new ForkJoinPool();
        AddTaskRet task=new AddTaskRet(0,nums.length);
        forkJoinPool.execute(task);
        System.out.println(task.join());
    }





}
