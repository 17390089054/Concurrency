package org.wrf.concurrent.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.util.concurrent.CopyOnWriteArrayList
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 线程安全的ArrayList 
 * 基于复制机制  当线程要写的时候将复制一份副本，对副本执行写操作，完成后将元数据引用指向副本对象地址
 * 适合于读多于写的场合 读不互斥 即读操作可以多个线程同时访问  写操作互斥、必须获得该对象的锁才能进行操作
 * 语法上表现为ReentrantLock.lock() 上锁  ReentrantLock.unlock()解锁
 * 它可以提供高并发下的并发读取，保证结果的一致性，但不保证过程的一致性
 * 
 * 缺点:内存开销大
 * 
 * @Package: org.wrf.concurrent.collections 
 * @author: knight   
 * @date: 2019年4月20日 下午10:16:34
 */
public class CopyOnWriteArrayListDemo {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		list.add("one");
		list.add("three");
		list.add(1,"two");
		System.out.println(list.get(1));
		if(list.contains("three")) {
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		
	}
}
