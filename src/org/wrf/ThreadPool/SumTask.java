package org.wrf.ThreadPool;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 100范围内求和
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ThreadPool 
 * @author: knight   
 * @date: 2019年11月2日 下午10:06:21
 */
public class SumTask implements Callable<Integer>{
	//定义每个线程计算的区间
	private int startNumber;
	private int endNumber;
	
	public SumTask(int startNumber, int endNumber) {
		super();
		this.startNumber = startNumber;
		this.endNumber = endNumber;
	}
	
	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=startNumber;i<=endNumber;i++)
			sum+=i;
		Thread.sleep(new Random().nextInt(1000));
		System.out.printf("%s: %d\n",Thread.currentThread().getName(),sum);
		return sum;
	}

}
