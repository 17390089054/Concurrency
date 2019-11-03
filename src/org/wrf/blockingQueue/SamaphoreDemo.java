package org.wrf.blockingQueue;

import java.util.concurrent.Semaphore;

public class SamaphoreDemo {
	public static void main(String[] args) {
		//一次运行3个人进行访问
		final Semaphore semaphore=new Semaphore(3);
		for(int i=0;i<10;i++) {
			final int no=i;
			Runnable thread=new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("用户"+no+"连接上了:");
						Thread.sleep(300L);
						//获取接下来执行的许可
						semaphore.acquire();
						System.out.println("用户"+no+"开始访问后台程序...");
						
						//模拟用户访问过程
						Thread.sleep(1000L);
						//释放允许下一个线程访问
						semaphore.release();
						
						System.out.println("用户"+no+"访问结束");
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			new Thread(thread).start();
		}
		System.out.println("Main thread end!");	
	}
	
}
