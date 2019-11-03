package org.wrf.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 ReentrantLock
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * Lock的实现类，是一个互斥的同步器，具有拓展的能力。
 * 在竞争条件下，比synchronized伸缩性要高
 * 缺点:
 * 可能忘记释放锁定，需要手动释放
 * 竞争相同的锁定时，ReentrantLock的吞吐量比synchronized大
 * @Package: org.wrf.thread.lock 
 * @author: knight   
 * @date: 2019年4月20日 下午4:36:38
 */
public class ReentrantLockDemo2 {
	public static void main(String[] args) {
		final Count count=new ReentrantLockDemo2().new Count();
		for(int i=0;i<2;i++) {
			new Thread() {
				@Override
				public void run() {
					count.put();
				}
			}.start();
		}
		
		for(int i=0;i<2;i++) {
			new Thread() {
				public void run() {
					count.get();
				};
			}.start();
		}
	}

	//两个方法之间使用相同的锁
	class Count{
		final ReentrantLock lock=new ReentrantLock();
		public void get() {
			try {
				//加锁
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"-->get begin");
				//模拟干活
				Thread.sleep(1000L);
				System.out.println(Thread.currentThread().getName()+"-->get end");
				//解锁
				lock.unlock();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public void put() {
			try {
				//加锁
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"-->put begin");
				//模拟干活
				Thread.sleep(1000L);
				System.out.println(Thread.currentThread().getName()+"-->put end");
				//解锁
				lock.unlock();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
