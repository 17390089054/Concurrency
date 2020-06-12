package org.wrf.monitor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
public class MonitorThreadPoolExecutorDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(500L);
		ExecutorService executor=new MonitorThreadPoolExecutor(5, 5, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue());
		for(int i=0;i<3;i++) {
			Runnable runnable=new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(100L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			executor.execute(runnable);
		}
		executor.shutdown();
		System.out.println("Thread Main End!");
		
	}
}

class MonitorThreadPoolExecutor extends ThreadPoolExecutor{

	public MonitorThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		// TODO Auto-generated method stub
		System.out.println("work_task before:"+t.getName());
	}
	
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		// TODO Auto-generated method stub
		super.afterExecute(r, t);
		System.out.println("work_task after worker thread is:"+r);
	}
	
	@Override
	protected void terminated() {
		// TODO Auto-generated method stub
		System.out.println("terminated getCorePoolSize:"
		+this.getCorePoolSize()+";getPoolSize:"+this.getPoolSize()
		+";getTaskCount:"+this.getTaskCount()+";getCompletedTaskCount:"+this.getCompletedTaskCount()
		+";getLargestPoolSize:"+this.getLargestPoolSize()+" ;getActiveCount:"+this.getActiveCount());
		System.out.println("ThreadPollExecutor terminated:");
	}
	
	
	
	
	
	
	
}
