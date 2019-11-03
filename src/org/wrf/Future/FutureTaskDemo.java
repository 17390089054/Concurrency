package org.wrf.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * java.util.concurrent.FutureTask
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 实现了java.lang.Runnable接口
 * 可以作为线程被执行
 * 实现了java.lang.concurrent.Future接口
 * 判断任务是否完成	能够中断任务	能够获取任务执行结果 
 * @Package: org.wrf.Future 
 * @author: knight   
 * @date: 2019年4月22日 上午8:23:44
 */
public class FutureTaskDemo {
	public static void main(String[] args) throws Exception {
		SonTask task1=new SonTask("Thread Son1");
		FutureTask<String> f1=new FutureTask<String>(task1);
		new Thread(f1).start();
		//只有得到返回结果后才会继续往下执行
		System.out.println("result_"+f1.get());
		
		//执行完指定线程，返回指定结果
		FutureTask<Integer> f2=new FutureTask<Integer>(new MyRun(),22);
		new Thread(f2).start();
		//只有得到指定结果后才会继续往下执行
		System.out.println("result_"+f2.get());
		
		System.out.println("Thread Main end!");
	}
}

class SonTask implements Callable<String>{
	private String name="";
	public SonTask(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(1000L);
		System.out.println(name+"任务计算完成");
		return "result_ll";
	}
}

class MyRun implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000L);//模拟干活
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("特定线程2完成");
	}
}


