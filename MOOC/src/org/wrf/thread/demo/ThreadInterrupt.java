package org.wrf.thread.demo;
/**
 * 线程中断
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * Java线程中断是一种协作机制，
 * 也就是说通过中断并不能直接终止另一个线程，而需要被中断线程的线程自己处理中断
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午3:03:51
 */
public class ThreadInterrupt implements Runnable{
	@Override
	public void run() {
		boolean stop=false;
		while(!stop) {
			System.out.println("My Thread is runnning....");
			long time=System.currentTimeMillis();
			while((System.currentTimeMillis()-time<1000)) {
				//让该循环持续一段时间，使用上面的话打印次数少点
			}
			if(Thread.currentThread().isInterrupted()) {
				break;
			}
		}
		System.out.println("My Thread exiting under request....");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread=new Thread(new ThreadInterrupt(),"InterruptThread");
		System.out.println("Starting thread....");
		thread.start();
		Thread.sleep(3000L);
		System.out.println("Interrupting thread....");
		thread.interrupt();
		System.out.println("线程是否中断:"+thread.isInterrupted());
		Thread.sleep(3000L);
		System.out.println("当前线程"+Thread.currentThread().getName()+"状态--->"+Thread.currentThread().getState());
		System.out.println("Stopping application...");
	}
	
	
	
}
