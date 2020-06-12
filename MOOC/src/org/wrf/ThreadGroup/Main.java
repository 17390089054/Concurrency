package org.wrf.ThreadGroup;

import java.util.concurrent.TimeUnit;

/**
 * 线程组 ThreadGroup
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 *  --线程的集合
	--树形结构，大线程组可以包括小线程组，执行操作
	--可以通过enumerate方法遍历组内的线程，执行操作
	--能够有效管理多个线程，但是管理效率低
	--任务分配和执行过程高度耦合
	--重复创建线程，关闭线程操作，无法重用线程
 * @Package: org.wrf.ThreadGroup 
 * @author: knight   
 * @date: 2019年11月2日 下午8:50:54
 */
public class Main {
	public static void main(String[] args) {
		//创建线程组
		ThreadGroup threadGroup=new ThreadGroup("Searcher");
		Result result=new Result();
		
		//创建10个线程
		Searcher seacher=new Searcher(result);
		for(int i=0;i<10;i++) {
			Thread thread=new Thread(threadGroup,seacher);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("=======1=======");
		//查看线程组消息
		System.out.printf("active 线程数量：%d\n",threadGroup.activeCount());
		System.out.printf("线程组信息明细\n");
		threadGroup.list();
		System.out.println("=======2========");
		
		//遍历活跃线程组
		Thread[] threads=new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for(int i=0;i<threadGroup.activeCount();i++) {
			System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
		}
		System.out.println("======3=======");
		
		waitFinish(threadGroup);
		
		threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while(threadGroup.activeCount()>9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
