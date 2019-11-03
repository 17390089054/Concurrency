package org.wrf.ConcurrentDataStructures.Queue;

import java.util.Queue;

public class QueueThread implements Runnable{
	public Queue<String>queue;
	
	public QueueThread(Queue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int i=0;
		while(i<10) {
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//把当前线程名称加入list中
			queue.add(Thread.currentThread().getName());
		}
		
		
		
	}

}
