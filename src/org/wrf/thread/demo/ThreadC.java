package org.wrf.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程创建方式三:实现juc并发包下的callable接口 重写call()方法
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 		Call接口需要提供泛型，且有返回值，返回值类型与泛型相同
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午2:12:47
 */
public class ThreadC implements Callable<String>{

	public String call() throws Exception {
		try {
			Thread.sleep(500L);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("This is Thread C");
		
		return "Thread C";
	}
	
	public static void main(String[] args) {
		ThreadC tc=new ThreadC();
		//使用FutureTask代理
		FutureTask<String>ft=new FutureTask<String>(tc);
		new Thread(ft).start();//启动方式与普通线程不同
		System.out.println("这是主线程，begin");
		//只有主线程get了，主线程才会继续往下面执行
		try {
			System.out.println("得到的返回结果是："+ft.get());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("这是主线程，end");
	}

}
