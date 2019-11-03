package org.wrf.blockingQueue;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * java.util.concurrent.CyclicBarrier 同步计数器
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 同步辅助类 允许一组线程相互等待，直至到达某个公共屏障点，
 * 然后所有的这组线程再往后面执行
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午9:58:41
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier barrier=new CyclicBarrier(3,new TotalTask());
		BillTask worker1=new BillTask("111",barrier);
		BillTask worker2=new BillTask("222",barrier);
		BillTask worker3=new BillTask("333",barrier);
		
		worker1.start();
		worker2.start();
		worker3.start();
		System.out.println("Main thread end!");
		
		
	}
	static class TotalTask extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("所有子任务都执行完了，就开始执行主任务。");
		}
	}
	
	static class BillTask extends Thread{
		private String billName;
		private CyclicBarrier barrier;
		public BillTask(String workerName,CyclicBarrier barrier) {
			this.billName=workerName;
			this.barrier = barrier;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("市区:"+billName+"运算开始：");
				Thread.sleep(1000L);
				System.out.println("市区:"+billName+"运算完成，等待中...");
				
				//假设一次运算不完，第二次要依赖第一次的运算结果，都达到这个节点之后免才会继续执行
				barrier.await();
 				
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
