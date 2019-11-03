package org.wrf.ForkJoin;

import java.util.concurrent.Future;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 * ForkJoin框架的简单使用
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ForkJoin 
 * @author: knight   
 * @date: 2019年4月22日 上午9:19:07
 */
public class ForkJoinTaskDemo {
	public static void main(String[] args) throws Exception {
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		CountTask task=new CountTask(1,5);
		Future<Integer>result=forkJoinPool.submit(task);
		System.out.println("1-5最终相加的结果："+result.get());
		
		CountTask task2=new CountTask(1,100);
		Future<Integer> result2=forkJoinPool.submit(task2);
		System.out.println("1-100最终相加结果："+result2.get());

		System.out.println("Thread Main End!");
	}
}

class CountTask extends RecursiveTask<Integer>{
	private static final long serialVersionUID = 1L;
	private static int splitSize=2;
	private int start,end;
	public CountTask(int start,int end) {
		this.start=start;
		this.end=end;
	}
	@Override
	protected Integer compute() {
		int sum=0;
		//如果任务已经不需要再拆分了就开始计算
		boolean canCompute=(end-start)<=splitSize;
		if(canCompute) {
			for(int i=start;i<=end;i++) {
				sum=sum+i;
			}
		}else {
			//拆分成两个子任务
			int middle=(start+end)/2;
			CountTask firstTask=new CountTask(start,middle);
			CountTask secondTask=new CountTask(middle+1,end);
			//开始执行
			firstTask.fork();
			secondTask.fork();
			//获取第一个子任务的结果，得不到结果，此线程不会往下执行
			int firstResult=firstTask.join();
			int secondResult=secondTask.join();
			//合并两个儿子的执行结果
			sum=firstResult+secondResult;
		}
		return sum;
	}
}

