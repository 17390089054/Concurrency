package org.wrf.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue 链表阻塞队列 生产者消费者采用不同的锁进行控制
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 现有的程序代码模拟产生了16个日志对象，并且需要运行16s才能打印完成这些日志
 * 请在程序中增加4个线程去调用parseLog()方法分别打印这16个日志对象
 * 程序只需要运行4s即可打印完成这些日志对象 
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午7:50:02
 */
public class LinkedBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		//新建一个等待队列
		final BlockingQueue<String>bq=new LinkedBlockingQueue<String>(16);
		//4个线程
		for(int i=0;i<4;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							//从队列取走队首元素 若队列为空 则当前线程阻塞
							String log=bq.take();
							parseLog(log);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}).start();
		}
		for(int i=0;i<16;i++) {
			String log=(i+1)+"--->";
			bq.put(log);//将数据存储到队列里 若队列已满，则当前线程阻塞
		}
		
	}

	//parseLog的内容不能进行改动
	public static void parseLog(String log) {
		System.out.println(log+System.currentTimeMillis());
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
