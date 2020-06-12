package org.wrf.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 *ReentrantReadWriteLock特性: 
 * 1.公平性:非公平锁
 * 2.重入性：写写读  写读  读读
 * 3.锁降级:写锁-->读锁
 * 4.锁升级:读锁-->写锁
 * 5.锁获取中断
 * 6.条件变量:写锁获取Condition
 * 7.重入锁:65535	
 * 
 * 读--读不互斥
 * 读--写互斥
 * 写--写互斥
 */
public class ReentrantReadWriteLockDemo {
	//创建一个ReentrantReadWriteLock对象
	private ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
	//抽取读锁和写锁
	//得到一个可被多个读操作共用的读锁，但他会排斥所有写操作
	private Lock readLock=rwl.readLock();
	//得到一个写锁、它会排斥其他所有其他的读操作和写操作
	private Lock writeLock=rwl.writeLock();

	//对所有访问者加读锁
	public double getTotalBalance() {
		int num=0;
		readLock.lock();
		try {
			num++;
		} finally {
			// TODO: handle finally clause
			readLock.unlock();
		}
		return num;
	}
	
	//对所有修改者加写锁
	public void transfer() {
		writeLock.lock();
		try {
			System.out.println("获取了写锁");
		} finally {
			// TODO: handle finally clause
			writeLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final Count ct=new ReentrantReadWriteLockDemo().new Count();
		for(int i=0;i<2;i++) {
			new Thread() {
				public void run() {
					ct.get();
				};
			}.start();
		}
		
		for(int i=0;i<2;i++) {
			new Thread() {
				public void run() {
					ct.put();
				};
			}.start();
		}
	}
	
	class Count{
		private final ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
		public void get() {
			rwl.readLock().lock();//上读锁，其他线程只能读不能写，具有并发性
			try {
				System.out.println(Thread.currentThread().getName()+" read start.");
				Thread.sleep(1000L);
				System.out.println(Thread.currentThread().getName()+" read end.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//释放读锁 
				rwl.readLock().unlock();
			}
		}
		
		public void put() {
			rwl.writeLock().lock();//上写锁，具有阻塞性
			try {
				System.out.println(Thread.currentThread().getName()+" write start.");
				Thread.sleep(1000L);
				System.out.println(Thread.currentThread().getName()+" write end.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//释放读锁 
				rwl.writeLock().unlock();//释放写锁
			}
		}
		
	}
	
}
