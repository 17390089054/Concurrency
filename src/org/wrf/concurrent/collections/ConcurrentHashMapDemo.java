package org.wrf.concurrent.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * java.util.concurrent.ConcurrentHashMap 继承与AbstractMap,实现了Map、java.io.Serializable接口 
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 线程安全的HashMap 
 * 采用分段式设计 ，分段加锁实现同步 读写锁分离 效率高
 * 
 * @Package: org.wrf.concurrent.collections 
 * @author: knight   
 * @date: 2019年4月20日 下午10:06:20
 */
public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		ConcurrentHashMap<String,Integer> c=new ConcurrentHashMap<String,Integer>();
		c.put("one", 1);
		c.put("two", 2);
		c.put("three", 3);
		System.out.println(c.get("two"));
		if(c.containsKey("two")&&c.get("two").equals(2)) {
			c.remove("two");
		}
		System.out.println(c);
		
	}
	
}
