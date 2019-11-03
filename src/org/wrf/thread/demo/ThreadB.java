package org.wrf.thread.demo;
/**
 * 多线程实现方式二：实现Runnable接口 重写run方法
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 获取该种方式实现的线程对象必须通过代理线程类创建，否则为普通对象
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午1:56:08
 */
public class ThreadB implements Runnable{
	@Override
	public void run() {
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("This is Thread B");
	}
	public static void main(String[] args) {
		Thread B=new Thread(new ThreadB());
		B.start();
		System.out.println("This is main Thread!");
		
		
		
		
	}
	
	
	
}
