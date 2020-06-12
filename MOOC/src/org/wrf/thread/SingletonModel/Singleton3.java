package org.wrf.thread.SingletonModel;
/**
 * 单例模式三
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 	线程安全  效率高  常用 
 * @Package: org.wrf.thread.SingletonModel 
 * @author: knight   
 * @date: 2019年4月20日 下午6:38:22
 */
public class Singleton3 {
	//返回的实例对象
	private static Singleton3 instance;
	//自定义一个锁
	private static byte[] lock=new byte[0];
	//私有化构造方法
	private Singleton3() {};
	//获取实例的方法(同步)
	public static synchronized Singleton3 getInstance() {
		//不存在则创建一个实例
		if(instance==null) {//double check提高效率
			synchronized (lock) {
				if(instance==null) {
					instance=new Singleton3();
				}
			}
		}
		
		return instance;
	}
	
	
}
