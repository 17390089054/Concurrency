package org.wrf.ConcurrentDataStructures.Set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * List测试类
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ConcurrentDataStructures.List 
 * @author: knight   
 * @date: 2019年11月3日 上午12:27:34
 */
public class SetTest {
	public static void main(String[] args) throws InterruptedException {
		//线程不安全
		Set<String> unsafeSet=new HashSet<String>();
		//线程安全
		Set<String> safeSet1=Collections.synchronizedSet(new HashSet<String>());
		//线程安全
		CopyOnWriteArraySet<String> safeSet2=new CopyOnWriteArraySet<>();
		
		SetThread t1=new SetThread(unsafeSet);
		SetThread t2=new SetThread(safeSet1);
		SetThread t3=new SetThread(safeSet2);
		
		for(int i=0;i<10;i++)
			new Thread(t1,String.valueOf(i)).start();
		for(int i=0;i<10;i++)
			new Thread(t2,String.valueOf(i)).start();
		for(int i=0;i<10;i++)
			new Thread(t3,String.valueOf(i)).start();
		
		//等待子线程执行完
		Thread.sleep(2000);
		
		System.out.println("setThread1.list.size() ="+t1.set.size());
		System.out.println("setThread2.list.size() ="+t2.set.size());
		System.out.println("setThread3.list.size() ="+t3.set.size());
		
		//输出list中的值
		System.out.println("unsafeSet：");
		for(String s:t1.set) {
			if(s==null)
				System.out.print("null ");
			else 
				System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("safeSet1. ");
		for(String s:t2.set) {
			if(s==null) 
				System.out.print("null ");
			else 
				System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("safeSet2：");
		for(String s:t3.set) {
			if(s==null)
				System.out.print("null ");
			else
				System.out.print(s+" ");
		}
	}
}
