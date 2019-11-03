package org.wrf.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * newSingleThreadExecutor() 单线程的线程池
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.executor 
 * @author: knight   
 * @date: 2019年4月21日 下午11:24:58
 */
public class Executor {
	public static void main(String[] args) {
		ExecutorService executor=Executors.newSingleThreadExecutor();
		for(int i=0;i<10;i++) {
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
