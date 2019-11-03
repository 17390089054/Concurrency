package org.wrf.ThreadTeamwork;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLactch
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ThreadTeamwork 
 * @author: knight   
 * @date: 2019年11月3日 下午6:11:58
 */
public class CountDownLatchExample {
	/**
	 * 设想百米赛跑比赛 发令枪发出信号后选手开始跑，全部选手跑到终点后比赛结束
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		int runnerCnt=10;
		CountDownLatch startSignal=new CountDownLatch(1);
		CountDownLatch doneSignal=new CountDownLatch(runnerCnt);
		
		for(int i=0;i<runnerCnt;i++)
			new Thread(new Worker(startSignal,doneSignal)).start();
		
		System.out.println("准备工作...");
		System.out.println("准备工作就绪");
		//let all threads proceed
		startSignal.countDown();
		System.out.println("比赛开始");
		//wait for all to finish
		doneSignal.await();
		System.out.println("比赛结束");
	}
	
	static class Worker implements Runnable{
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;
		
		public Worker(CountDownLatch startSignal,CountDownLatch doneSignal) {
			this.startSignal=startSignal;
			this.doneSignal=doneSignal;
		}
		
		@Override
		public void run() {
			try {
				startSignal.await();
				doWork();
				doneSignal.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void doWork() {
			System.out.println(Thread.currentThread().getName()+": 跑完全程");
		}
	}
}

