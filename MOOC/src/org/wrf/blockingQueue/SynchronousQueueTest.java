package org.wrf.blockingQueue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * java.util.concurrent.SynchronousQueue 同步队列
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 不存储元素阻塞队列	put()操作必须要等待get()操作	适合传递性场景
 * 
 * 线程程序中的Test1类中的代码在不断地生产数据
 * 然后交给TestDo.doSome()方法去处理
 * 就好像生产者在不断地生产数据，消费者在不断地消费数据
 * 
 * 请将程序改造成10个线程来消费生产者生产的数据，这些消费者都调用TestDo.doSome()方法去进行处理，
 * 故每个消费者需要一秒才能处理完，程序应该保证这些消费者线程依次有序地消费数据，只有上一个消费者消费完后，
 * 下一个消费者才能消费数据，下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。
 * 	
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午8:31:52
 */
public class SynchronousQueueTest {
	public static void main(String[] args) {
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		//定义一个Synchronous
		final SynchronousQueue<String>sq=new SynchronousQueue<String>();
		//定义一个数量为1的信号量，其作用相当于一个互斥锁
		final Semaphore sem=new Semaphore(1);
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						sem.acquire();
						
						String input=sq.take();
						String output=TestDo.doSome(input);
						System.out.println(Thread.currentThread().getName()+":"+output);

						sem.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
		}
		
		for(int i=0;i<10;i++) {
			String input=i+"";
			try {
				sq.put(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}

class TestDo{
	public static String doSome(String input) {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String output=input+":"+(System.currentTimeMillis()/1000);
		return output;
	}
}

