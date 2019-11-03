package org.wrf.blockingQueue;

import java.util.concurrent.TransferQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * java.util.concurrent.TransferQueue 链表传输队列  无界传输阻塞队列
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午9:23:25
 */
public class LucyNumberGenerator {
	public static void main(String[] args) {
		TransferQueue<String> queue=new LinkedTransferQueue<String>();
		Thread producer=new Thread(new Producer(queue));
		//设置为守护线程使得线程执行结束后程序自动结束
		producer.setDaemon(true);
		producer.start();
		
		for(int i=0;i<10;i++) {
			Thread consumer=new Thread(new Consumer(queue));
			consumer.setDaemon(true);
			consumer.start();
			try {
				//消费者进程休眠1s以便生产者获得CPU 从而生产产品
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
