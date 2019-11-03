package org.wrf.thread.demo;

public class ThreadT implements Runnable{

	@Override
	public void run() {
		int num=Integer.parseInt("TTT");
		System.out.println(num);
	}

}
