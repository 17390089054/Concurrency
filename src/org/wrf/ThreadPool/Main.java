package org.wrf.ThreadPool;
/**
 * 主方法
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ThreadPool 
 * @author: knight   
 * @date: 2019年11月2日 下午9:42:55
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		//创建一个服务器
		Server server=new Server();
		//创建100个任务，并发给执行器，等待完成
		for(int i=0;i<100;i++) {
			Task task=new Task("Task"+i);
			Thread.sleep(10);
			server.submitTask(task);
		}
		server.endServer();
	}

}
