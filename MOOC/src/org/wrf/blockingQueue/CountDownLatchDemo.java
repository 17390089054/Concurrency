package org.wrf.blockingQueue;

import java.util.concurrent.CountDownLatch;

/**
 * java.util.concurrent.CountDownLatch 同步计数器
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * countDown()倒数到0 
 * await()等待倒数到0 否则阻塞
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午9:32:16
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(3);
		Worker worker1=new Worker("Jack 程序员1",latch);
		Worker worker2=new Worker("Rose 程序员2",latch);
		Worker worker3=new Worker("Json 程序员3",latch);
		worker1.start();
		worker2.start();
		worker3.start();
		
		latch.await();
		System.out.println("Main thread end!");
	}
	static class Worker extends Thread{
		private String workerName;
		private CountDownLatch latch;
		public Worker(String workerName,CountDownLatch latch) {
			this.workerName=workerName;
			this.latch=latch;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("Worker:"+workerName+"is begin.");
				Thread.sleep(1000L);
				System.out.println("Worker:"+workerName+"is end.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//模仿干活
			latch.countDown();
		}
	}
	
	
	
}
