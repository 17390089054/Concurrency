package org.wrf.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 分任务求和
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ForkJoin 
 * @author: knight   
 * @date: 2019年11月2日 下午11:25:58
 */
public class SumTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建执行线程池
		ForkJoinPool pool=new ForkJoinPool();
		//ForkJoinPool pool=new ForkJoinPool();
		
		//创建任务
		SumTask task=new SumTask(1, 10000000);
		
		//提交任务
		ForkJoinTask<Long> result=pool.submit(task);
		
		do {
			System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
			System.out.printf("Main: Paralelism: %d\n",pool.getParallelism());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!task.isDone());
		
		//输出结果
		System.out.println(result.get().toString());
	}
}
