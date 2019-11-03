package org.wrf.blockingQueue;

import java.util.concurrent.DelayQueue;
/**
 * java.util.concurrent.DelayQueue  延时队列
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 支持延时获取元素 	优先级队列	无阻塞队列
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午8:21:21
 */
public class DelayQueueTest {
	public static void main(String[] args) {
		//新建一个等待队列
		final DelayQueue<Student> dq=new DelayQueue<Student>();
		for(int i=0;i<5;i++) {
			Student student=new Student("学生"+i,Math.round(Math.random()*10+i));
			//将数据存到队列里
			dq.put(student);
		}
		//获取但不移除此队列的头部：如果此队列为空，则返回null
		System.out.println("dq.peek()"+dq.peek().getName());
		//获取并移除此队列的头部，在可从此队列获得到期延迟的元素，或者到达指定的等待时间之前一直等待
		//poll(long timeout,TimeUnit unit); 
	}
}
