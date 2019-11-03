package org.wrf.thread.demo;
/**
 * 线程副本:ThreadLocal
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本
 * 每个线程都可以独立地操作把自己的变量副本，而不会影响其他线程对应的副本。
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午3:23:22
 */
public class ThreadMain {
	//1.通过匿名内部类覆盖ThreadLocal的initialValue方法，指定初始值
	private static ThreadLocal<Integer>seqNum=new ThreadLocal<Integer>(){
		public Integer initialValue() {
			return 0;
		}
	};
	
	public ThreadLocal<Integer>getThreadLocal(){
		return seqNum;
	}
	//2.获取下一个序列值
	public int getNextNum() {
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		ThreadMain sn=new ThreadMain();
		//3.3个线程共享sn,各自产生序列号
		Thread c1=new Thread(new TestClient(sn));
		Thread c2=new Thread(new TestClient(sn));
		Thread c3=new Thread(new TestClient(sn));
		c1.start();
		c2.start();
		c3.start();
	}
	public static class TestClient implements Runnable{
		private ThreadMain sn;
		public TestClient(ThreadMain sn) {
			this.sn = sn;
		}
		
		@Override
		public void run() {
			for(int i=0;i<3;i++) {
				//4.每个线程执行打印出3个序列值
				System.out.println("thread"+Thread.currentThread().getName()+"-->"+sn.getNextNum());
			}
			//移除对应的ThreadLocal
			sn.getThreadLocal().remove();
		}
		
		
		
	}
	
	
	
	
	

}
