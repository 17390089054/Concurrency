package org.wrf.ThreadGroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 辅助类
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ThreadGroup 
 * @author: knight   
 * @date: 2019年11月2日 下午8:58:20
 */
public class Searcher implements Runnable{
	private Result result;
	public Searcher(Result result) {
		super();
		this.result = result;
	}

	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.printf("Thread %s: 启动\n",name);
		
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.printf("Thread %s: 被中断\n",name);
			e.printStackTrace();
			return;
		}
		
		System.out.printf("Thread %s: 完成\n",name);
	}

	private void doTask() throws InterruptedException {
		Random random=new Random(new Date().getTime());
		int value=(int)(random.nextDouble()*100);
		System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
		TimeUnit.SECONDS.sleep(value);
	}

}
