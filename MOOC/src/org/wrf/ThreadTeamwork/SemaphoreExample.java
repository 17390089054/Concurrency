package org.wrf.ThreadTeamwork;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	private final  Semaphore placeSemaphore=new Semaphore(5);
	
	public boolean parking() {
		if(placeSemaphore.tryAcquire()) {
			System.out.println(Thread.currentThread().getName()+":停车成功");
			return true;
		}else {
			System.out.println(Thread.currentThread().getName()+":没有空位");
			return false;
		}
	}
	
	public void leaving() {
		placeSemaphore.release();
		System.out.println(Thread.currentThread().getName()+":开走");
	}
	
	/**
	 * 现有一地下车库，共有车位5个，有10辆车需要停放，每次停放时，去申请信号量
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int tryToParkCnt=10;
		
		final SemaphoreExample semaphoreExample=new SemaphoreExample();
		
		Thread[] parkers=new Thread[tryToParkCnt];
		
		for(int i=0;i<tryToParkCnt;i++) {
			parkers[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					long randomTime=(long)Math.random()*1000;
					try {
						Thread.sleep(randomTime);
						if(semaphoreExample.parking()) {
							long parkingTime=(long)(Math.random()*1200);
							Thread.sleep(parkingTime);
							semaphoreExample.leaving();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		parkers[i].start();
	}
		for(int i=0;i<tryToParkCnt;i++)
			parkers[i].join();
	}
	
}
