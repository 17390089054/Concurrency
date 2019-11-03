package org.wrf.thread.SingletonModel;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 单例模式四
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 	线程安全  效率高  常用 
 * @Package: org.wrf.thread.SingletonModel 
 * @author: knight   
 * @date: 2019年4月20日 下午6:38:22
 */
public class Singleton4 {
	//返回的实例对象
	private static Singleton4 instance;
	//使用ReentrantLock锁
	private static ReentrantLock lock=new ReentrantLock();
	//私有化构造方法
	private Singleton4() {};
	//获取实例的方法(同步)
	public static synchronized Singleton4 getInstance() {
		//不存在则创建一个实例
		if(instance==null) {//double check提高效率
				//加锁进行同步
				lock.lock();
				if(instance==null) {
					instance=new Singleton4();
				}
				//一定要记得释放锁对象
				lock.unlock();
		}
		
		return instance;
	}
	
	
}
