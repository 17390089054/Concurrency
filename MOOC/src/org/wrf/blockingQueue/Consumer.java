package org.wrf.blockingQueue;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
	private final TransferQueue<String> queue;
	
	public Consumer(TransferQueue<String>queue) {
		this.queue=queue;
	}
	@Override
	public void run() {
		try {
			System.out.println("Consumer"+Thread.currentThread().getName()+queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
