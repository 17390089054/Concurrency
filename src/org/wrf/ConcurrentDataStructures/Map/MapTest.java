package org.wrf.ConcurrentDataStructures.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ConcurrentDataStructures.Map 
 * @author: knight   
 * @date: 2019年11月3日 下午2:04:31
 */
public class MapTest {
	public static void main(String[] args) throws InterruptedException {
		//线程不安全
		Map<Integer,String> unsafeMap=new HashMap<Integer,String>();
		//线程安全
		Map<Integer,String> safeMap1=Collections.synchronizedMap(new HashMap<Integer,String>());
		//线程安全
		ConcurrentHashMap<Integer,String> safeMap2=new ConcurrentHashMap<Integer,String>();
		
		MapThread t1=new MapThread(unsafeMap);
		MapThread t2=new MapThread(safeMap1);
		MapThread t3=new MapThread(safeMap2);
		
		//unsafeMap的运行测试
		for(int i=0;i<10;i++)
			new Thread(t1).start();
		for(int i=0;i<10;i++)
			new Thread(t2).start();
		for(int i=0;i<10;i++)
			new Thread(t3).start();
		
		//等待子线程执行完
		Thread.sleep(2000);
		
		System.out.println("mapThread1.map.size() ="+t1.map.size());
		System.out.println("mapThread2.map.size() ="+t2.map.size());
		System.out.println("mapThread3.map.size() ="+t3.map.size());
		
		//输出set中的值
		System.out.println("unsafeMap：");
		Iterator<Entry<Integer, String>> it=t1.map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String>entry=it.next();
			//获取key
			System.out.println(entry.getKey()+":");
			//获取value
			System.out.println(entry.getValue()+" ");
		}
		System.out.println();
		
		System.out.println("safeMap1:");
		it=t2.map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String> entry=it.next();
			//获取key
			System.out.println(entry.getKey()+":");
			//获取value
			System.out.println(entry.getValue()+" ");
		}
		System.out.println();
		
		System.out.println("safeMap2:");
		it=t3.map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String>entry=it.next();
			//获取key
			System.out.println(entry.getKey()+":");
			//获取value
			System.out.println(entry.getValue()+" ");
		}
		System.out.println();
		System.out.println("mapThread1.map.size()="+t1.map.size());
		System.out.println("mapThread2.map.size()="+t2.map.size());
		System.out.println("mapThread3.map.size()="+t3.map.size());
		
	}
}
