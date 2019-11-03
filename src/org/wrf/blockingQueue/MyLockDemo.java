package org.wrf.blockingQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
@SuppressWarnings("all")

/**
 * AbstractQueuedSynchronizer 抽象化队列同步器
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.blockingQueue 
 * @author: knight   
 * @date: 2019年4月21日 下午9:47:50
 */
public class MyLockDemo implements Lock {
	//内部类，自定义同步器
	private static class Sync extends AbstractQueuedSynchronizer{
		//是否处于占用状态
		@Override
		protected boolean isHeldExclusively() {
			// TODO Auto-generated method stub
			return getState()==1;
		}
		//状态为0的时候获取锁
		@Override
		protected boolean tryAcquire(int acquires) {
			assert acquires==1;
			if(compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			
			return false;
		}
		//释放锁，将状态设置为0
		@Override
		protected boolean tryRelease(int releases) {
			assert releases==1;
			if(getState()==0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		
		//返回一个Condition，每个condition都包含了一个condition队列
		Condition newCondition() {
			return new ConditionObject();
		}
	}
	
	//利用内部类声明一个AbstractQueueSynchronizer子类
	private final Sync sync=new Sync();

	@Override
	public void lock() {
		// TODO Auto-generated method stub
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
