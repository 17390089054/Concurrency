package org.wrf.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * newFixedThreadPool() 可伸缩的线程池的使用
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.executor 
 * @author: knight   
 * @date: 2019年4月21日 下午11:24:58
 */
public class Executor2 {
	public static void main(String[] args) {
		//创建一个固定大小的线程池
		ExecutorService executor=Executors.newFixedThreadPool(5);
		for(int i=0;i<20;i++) {
			final int no=i;
			Runnable runnable=new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("into"+no);
						Thread.sleep(1000L);
						System.out.println("end"+no);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			executor.execute(runnable);
		}
		executor.shutdown();
		System.out.println("Thread Main End!");
	}
}
