package org.wrf.concurrent.collections;

import java.util.Iterator;
import java.util.Vector;

/**
 * java.util.Vetor
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 继承自AbstractList，实现了List、RandomAccess、Cloneable这些接口
 * 既是一个队列，可以实现增加、删除、修改、遍历等功能
 * 也是一个数组，可以实现随机访问的功能
 * 实现了Cloneable接口，即实现了clone()函数、它能被克隆
 * 线程安全，内部方法实现了synchronized同步操作
 * @Package: org.wrf.concurrent.collections 
 * @author: knight   
 * @date: 2019年4月20日 下午10:44:07
 */
public class VectorDemo {
	public static void main(String[] args) {
		Vector<String>list=new Vector<String>();
		list.addElement("one");
		list.addElement("two");
		list.addElement("three");
		list.removeElement("two");
		if(list.contains("three")) {
			Iterator<String> it=list.iterator();
			while(it.hasNext()) {
				System.out.println(it.next()   );
			}
		}
		
	}

}
