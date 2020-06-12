package org.wrf.ConcurrentDataStructures.List;

import java.util.List;

/**
 * 线程List任务类
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ConcurrentDataStructures.List 
 * @author: knight   
 * @date: 2019年11月3日 上午12:24:51
 */
public class ListThread implements Runnable{
	public List<String>list;
	public ListThread(List<String> list) {
		super();
		this.list = list;
	}
	@Override
	public void run() {
		int i=0;
		while(i<10) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(Thread.currentThread().getName());
			i++;
		}
		
	}

}
