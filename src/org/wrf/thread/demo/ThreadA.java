package org.wrf.thread.demo;
/**
 * 创建线程的方式一：继承自java.lang.Thread类，重写run方法
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 缺陷：Java类只能extends一个父类
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午1:51:25
 */
public class ThreadA extends Thread{

	@Override
	public void run() {
		try {
			//模拟线程运行500ms
			Thread.sleep(500L);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("This is Thread A");
	}
	
	public static void main(String[] args) {
		ThreadA ta=new ThreadA();
		ta.start();
		System.out.println("This is Main Thread");
		
	}

}
