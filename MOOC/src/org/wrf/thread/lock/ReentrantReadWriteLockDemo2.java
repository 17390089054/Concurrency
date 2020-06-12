package org.wrf.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo2 {
	//假设这里面存在数据缓存
	private final Map<String,Object>map=new HashMap<String,Object>();
	
	private final ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
	
	public Object readWrite(String id) {
			Object value=null;
			//首先开启读锁，从缓存中去取
			rwlock.readLock().lock();
			try {
				value=map.get(id);
				if(value==null) {//如果缓存中没有释放读锁，上写锁
					rwlock.readLock().unlock();
					rwlock.writeLock().lock();
					try {
						if(value==null)//此时可以去数据库中查找
							value="aaa";
					}finally {
						rwlock.writeLock().unlock();
					}
				}
			}finally {
				rwlock.readLock().unlock();//释放读锁
			}
		return value;
	}
	
	
	
	
	
}
