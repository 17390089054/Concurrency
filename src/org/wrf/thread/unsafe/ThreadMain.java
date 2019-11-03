package org.wrf.thread.unsafe;

public class ThreadMain {
	public static void main(String[] args) {
		Count count=new Count();
		for(int i=0;i<5;i++) {
				ThreadA t=new ThreadA(count);
				t.start();
		}
		try {
			//5个人干完活
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("5个人干完活最后的值"+count.num);
		
	}
}
