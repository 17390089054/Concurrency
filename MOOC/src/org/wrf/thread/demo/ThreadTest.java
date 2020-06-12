package org.wrf.thread.demo;

public class ThreadTest implements Runnable{

	@Override
	public void run() {
		boolean isRunnning=false;
		while(!isRunnning) {
			System.out.println(Thread.currentThread().getName()+"is running!");
			try {
				Thread.sleep(200L);
			}catch (InterruptedException e) {//外部线程打断当前线程
				break;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Thread t=new Thread(new ThreadTest());
		System.out.println("Thread start");
		t.start();
		System.out.println("interrupt thread");
		t.interrupt();
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getState());
		
	}
	
	
}


