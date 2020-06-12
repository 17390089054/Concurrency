package org.wrf.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池管理线程
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ThreadPool 
 * @author: knight   
 * @date: 2019年11月2日 下午9:28:18
 */
public class Server {
	//线程池
	ThreadPoolExecutor executor;
	
	public Server() {
		//创建固定大小的线程池
		//executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
		executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
	}
	
	//向线程池提交任务
	public void submitTask(Task task) {
		System.out.printf("Server: A new task has arrived\n");
		
		executor.execute(task);
		
		System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
		System.out.printf("Server: Completed Tasks:%d\n",executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
	
	

}
