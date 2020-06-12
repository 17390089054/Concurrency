package org.wrf.ConcurrentDataStructures.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 队列测试
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ConcurrentDataStructures.Queue 
 * @author: knight   
 * @date: 2019年11月3日 下午2:59:30
 */
public class QueueTest {
	public static void main(String[] args) throws InterruptedException {
		//线程不安全
		Deque<String> unsafeQueue=new ArrayDeque<String>();
		//线程安全
		ConcurrentLinkedDeque<String> safeQueue1=new ConcurrentLinkedDeque<String>();
		//线程安全
		ArrayBlockingQueue<String> safeQueue2=new ArrayBlockingQueue<String>(100);
		
		QueueThread t1=new QueueThread(unsafeQueue);
		QueueThread t2=new QueueThread(safeQueue1);
		QueueThread t3=new QueueThread(safeQueue2);
		
		for(int i=0;i<10;i++)
			new Thread(t1,String.valueOf(i)).start();
		for(int i=0;i<10;i++)
			new Thread(t2,String.valueOf(i)).start();
		for(int i=0;i<10;i++)
			new Thread(t3,String.valueOf(i)).start();
		//等待子线程执行完
		Thread.sleep(2000);
		
		System.out.println("queueThread1.queue.size() ="+t1.queue.size());
		System.out.println("queueThread2.queue.size() ="+t2.queue.size());
		System.out.println("queueThread3.queue.size() ="+t3.queue.size());
		
		//输出queue中的值
		System.out.println("unsafeQueue: ");
		for(String s:t1.queue)
			System.out.print(s+" ");
		System.out.println();
		System.out.println("safeQueue1: ");
		for(String s:t2.queue)
			System.out.print(s+" ");
		System.out.println();
		System.out.println("safeQueue2: ");
		for(String s:t3.queue)
			System.out.print(s+" ");
	}
}
