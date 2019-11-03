package org.wrf.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * 分治任务  RecursiveTask<E>
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ForkJoin 
 * @author: knight   
 * @date: 2019年11月2日 下午11:12:47
 */
public class SumTask extends RecursiveTask<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int start;
	private int end;
	private static final int threadhold=5;
	
	public SumTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		Long sum=0L;
		//任务小于阀值直接计算
		boolean canCompute=(end-start) <=threadhold;
		if(canCompute) {
			for(int i=start;i<=end;i++)
				sum+=i;
		}else {
			//任务大于阀值，分裂为2个任务
			int middle=(end+start)/2;
			SumTask subTask1=new SumTask(start, middle);
			SumTask subTask2=new SumTask(middle+1,end);
			
			invokeAll(subTask1,subTask2);
			
			Long sum1=subTask1.join();
			Long sum2=subTask2.join();
			
			//结果合并
			sum=sum1+sum2;
		}
		return sum;
	}
	
	
}
