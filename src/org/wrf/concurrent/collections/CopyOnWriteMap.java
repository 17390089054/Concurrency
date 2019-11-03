package org.wrf.concurrent.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基于CopyOnWrite机制实现CopyOnWriteMap
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.concurrent.collections 
 * @author: knight   
 * @date: 2019年4月20日 下午10:34:13
 */
public class CopyOnWriteMap<K,V> implements Cloneable,Map<K,V>{
	private volatile Map<K,V> internalMap;

	public CopyOnWriteMap() {
		internalMap=new HashMap<K,V>();
	}
	
	public V put(K key,V value) {
		synchronized (this) {
			Map<K,V>newMap=new HashMap<K,V>(internalMap);
			V val=newMap.put(key, value);
			internalMap=newMap;
			return val;
		}
	}
	
	public V get(Object key) {
		return internalMap.get(key);
	}
	
	public void putAll(Map<? extends K,? extends V>newData) {
		synchronized (this) {
			Map<K,V>newMap=new HashMap<K,V>(internalMap);
			newMap.putAll(newData);
			internalMap=newMap;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
