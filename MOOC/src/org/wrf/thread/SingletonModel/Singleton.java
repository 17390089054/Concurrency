package org.wrf.thread.SingletonModel;
/**
 * 单例模式一
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 	线程不安全 不正确
 * @Package: org.wrf.thread.SingletonModel 
 * @author: knight   
 * @date: 2019年4月20日 下午6:38:22
 */
public class Singleton {
	//返回的实例对象
	private static Singleton instance;
	//私有化构造方法
	private Singleton() {};
	//获取实例的方法
	public static Singleton getInstance() {
		//不存在则创建一个实例
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
	
	
}
