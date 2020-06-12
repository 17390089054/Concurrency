package org.wrf.thread.demo;
/**
 * ExcptionHandler处理unchecked exception
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * setUncaughtExceptionHandler必须执行在start方法之前
 * @Package: org.wrf.thread.demo 
 * @author: knight   
 * @date: 2019年4月20日 下午4:04:02
 */
public class ExceptionHandlerMain {
	public static void main(String[] args) {
		Thread t=new Thread(new ThreadT());
		t.setUncaughtExceptionHandler(new ExceptionHandlerThreadT());
		t.start();
	}

}
