package org.wrf.concurrent.collections;

import java.util.Hashtable;

/**
 * java.util.Hashtable 继承自Dictionary 实现了Map、Cloneable、java.io.Serializable接口
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 大部分方法实现了同步(synchronized) 线程安全
 * key和value不允许null值
 * @Package: org.wrf.concurrent.collections 
 * @author: knight   
 * @date: 2019年4月20日 下午10:00:28
 */
public class HashTableDemo {
	public static void main(String[] args) {
		Hashtable<String,Integer> table=new Hashtable<String,Integer>();
		table.put("one", 1);
		table.put("two", 2);
		table.put("three", 3);
		
		Integer n=table.get("two");
		if(n!=null) {
			System.out.println("two="+n);
		}
		
		
	}
}
