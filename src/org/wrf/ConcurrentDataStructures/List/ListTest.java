package org.wrf.ConcurrentDataStructures.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * List测试类
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ConcurrentDataStructures.List 
 * @author: knight   
 * @date: 2019年11月3日 上午12:27:34
 */
public class ListTest {
	public static void main(String[] args) throws InterruptedException {
		//线程不安全
		List<String> unsafeList=new ArrayList<String>();
		//线程安全
		List<String> safeList1=Collections.synchronizedList(new ArrayList<String>());
		//线程安全
		CopyOnWriteArrayList<String> safeList2=new CopyOnWriteArrayList<>();
		
		ListThread t1=new ListThread(unsafeList);
		ListThread t2=new ListThread(safeList1);
		ListThread t3=new ListThread(safeList2);
		
		for(int i=0;i<10;i++)
			new Thread(t1,String.valueOf(i)).start();
		for(int i=0;i<10;i++)
			new Thread(t2,String.valueOf(i)).start();
		for(int i=0;i<10;i++)
			new Thread(t3,String.valueOf(i)).start();
		
		//等待子线程执行完
		Thread.sleep(2000);
		
		System.out.println("listThread1.list.size() ="+t1.list.size());
		System.out.println("listThread2.list.size() ="+t2.list.size());
		System.out.println("listThread3.list.size() ="+t3.list.size());
		
		//输出list中的值
		System.out.println("unsafeList：");
		for(String s:t1.list) {
			if(s==null)
				System.out.print("null ");
			else 
				System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("safeList1. ");
		for(String s:t2.list) {
			if(s==null) 
				System.out.print("null ");
			else 
				System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("safeList2：");
		for(String s:t3.list) {
			if(s==null)
				System.out.print("null ");
			else
				System.out.print(s+" ");
		}
	}
}
