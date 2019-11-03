package org.wrf.ThreadTeamwork;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {
	public static void main(String[] args) throws Exception {
		//executeAtFixTime();
		//executeFixedRate();
		executeFixedDelay();
	}
	
	public static void executeAtFixTime() throws InterruptedException {
		ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
		executor.schedule(new MyTask3(),1, TimeUnit.SECONDS);
		Thread.sleep(20000);
		executor.shutdown();
	}
	/**
	 * 周期任务 固定速率 是以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕
	 * 如果上一个任务执行完毕，则当前任务立即执行，如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行
	 * @throws InterruptedException
	 */
	public static void executeFixedRate() throws InterruptedException {
		ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new MyTask3(), 1, 3000, TimeUnit.MILLISECONDS);
		Thread.sleep(20000);
		executor.shutdown();
	}
	
	/**
	 * 周期任务 固定延时 是以上一个任务结束开始计时 period时间过去后，立即执行
	 * @throws InterruptedException 
	 */
	public static void executeFixedDelay() throws InterruptedException {
		ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
		executor.scheduleWithFixedDelay(new MyTask3(), 
				1, 3000,TimeUnit.MILLISECONDS);
		Thread.sleep(20000);
		executor.shutdown();
	}
	
}
class MyTask3 implements Runnable{

	@Override
	public void run() {
		System.out.println("时间为："+new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

