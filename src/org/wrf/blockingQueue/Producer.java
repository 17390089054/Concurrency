package org.wrf.blockingQueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable{
	private final TransferQueue<String> queue;
	public Producer(TransferQueue<String>queue) {
		this.queue=queue;
	}
	private String produce() {
		return "your lucky number "+(new Random().nextInt(100));
	}
	@Override
	public void run() {
		while(true) {
				try {
					if(queue.hasWaitingConsumer()) {
						queue.transfer(produce());
					}
					//生产者睡眠1秒 这样可以看出程序的执行过程
					TimeUnit.SECONDS.sleep(1);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
