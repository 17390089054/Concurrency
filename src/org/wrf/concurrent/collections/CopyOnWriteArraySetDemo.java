package org.wrf.concurrent.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * java.util.concurrent.ConcurrentArraySet
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 在CopyOnWriteArrayList的基础上使用了Java的装饰者模式
 * 基本用法与CopyOnWriteArrayList相同
 * @Package: org.wrf.concurrent.collections 
 * @author: knight   
 * @date: 2019年4月20日 下午10:27:36
 */
public class CopyOnWriteArraySetDemo {
	public static void main(String[] args) {
		CopyOnWriteArraySet <String>set=new CopyOnWriteArraySet<String>();
		set.add("one");
		set.add("two");
		set.add("two");
		set.add("three");
		if(set.contains("three")) {
			Iterator<String> iterator = set.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}
}
