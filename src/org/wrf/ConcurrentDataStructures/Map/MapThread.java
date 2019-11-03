package org.wrf.ConcurrentDataStructures.Map;

import java.util.Map;

public class MapThread implements Runnable{
	public Map<Integer,String>map;
	
	public MapThread(Map<Integer, String> map) {
		super();
		this.map = map;
	}

	@Override
	public void run() {
		int i=0;
		while(i<100) {
			//把当前线程名称放入map中
			map.put(i++, Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
