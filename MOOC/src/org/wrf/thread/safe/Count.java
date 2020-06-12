package org.wrf.thread.safe;
/**
 * synchronized隐式锁的用法
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * 1.在方法声明时使用 放在权限修饰符与返回值类型之间，作用域为当前整个对象
 * 2.修饰在代码块上面，对某一代码块使用synchronized(Object)，指定加锁对象
 * 当synchronized(this)时，二者没有多大区别
 * 
 * 效率：
 * 	同步方法体<方法体内的同步代码块(synchronized(this))< synchronized(lock)(private byte[] lock=new byte[1])
 * @Package: org.wrf.thread.safe 
 * @author: knight   
 * @date: 2019年4月20日 下午4:26:17
 */
public class Count {
	public int num=0;
	public synchronized void MethodA() {
		try {
			Thread.sleep(51);//模仿用户干活
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num+=1;
		System.out.println(Thread.currentThread().getName()+"-->"+num);
	}
	
	public void methodB() {
		synchronized (this) {
			try {
				Thread.sleep(51);//模拟用户干活
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num+=1;
			System.out.println(Thread.currentThread().getName()+"-->"+num);
		}
		
	}
	
	
}
