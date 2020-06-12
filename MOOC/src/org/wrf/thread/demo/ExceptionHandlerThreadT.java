package org.wrf.thread.demo;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * 线程异常的处理
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * run方法不允许throw exception,所有的异常必须在run方法内进行处理
 * Java多线程中，所有线程不允许抛出未捕获的checked exception,
 * 也就是说各个线程需要自己把自己的checked exception处理掉。这一点是通过
 * java.lang.Runnable.run()方法(run方法声明上没有checked exception部分)声明进行了约束
 * 但是线程依然有可能抛出unchecked exception 
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午3:51:53
 */
public class ExceptionHandlerThreadT implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread:%s\n",t.getId());
		System.out.printf("Exception: %s\n:%s\n",e.getClass().getName(),e.getMessage());
		
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n",t.getState());
	}

}
