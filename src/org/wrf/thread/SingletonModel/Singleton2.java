package org.wrf.thread.SingletonModel;
/**
 * 单例模式二
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 	线程安全  效率低
 * @Package: org.wrf.thread.SingletonModel 
 * @author: knight   
 * @date: 2019年4月20日 下午6:38:22
 */
public class Singleton2 {
	//返回的实例对象
	private static Singleton2 instance;
	//私有化构造方法
	private Singleton2() {};
	//获取实例的方法(同步)
	public static synchronized Singleton2 getInstance() {
		//不存在则创建一个实例
		if(instance==null) {
			instance=new Singleton2();
		}
		return instance;
	}
	
	
}
