package com.lottery.common.cache;

import net.sf.ehcache.Element;

/**
 * @Description: 缓存接口实现
 * @author 杰然不同
 * @date 2010-11-24
 */
public class Ehcache implements Cache{

	private net.sf.ehcache.Cache cache;
	
	public Ehcache(net.sf.ehcache.Cache cache){
		this.cache = cache;
	}

	public Object get(Object key) throws CacheException {
		try {
			if(key == null)
				return null;
			else{
				Element element = cache.get(key);
				if(element != null)
					return element.getObjectValue();
			}
			return null;
		} catch (net.sf.ehcache.CacheException e) {
			throw new CacheException(e);
		}
	}

	public void put(Object key, Object value) throws CacheException {
		try {
			Element element = new Element(key, value);
			cache.put(element);
		} catch (IllegalArgumentException  e) {
			throw new CacheException(e);
		} catch (IllegalStateException e){
			throw new CacheException(e);
		} catch (net.sf.ehcache.CacheException e){
			throw new CacheException(e);
		}
		
	}

	public void remove(Object key) throws CacheException {
		try {
			cache.remove(key);
		} catch (IllegalArgumentException  e) {
			throw new CacheException(e);
		} catch (IllegalStateException e){
			throw new CacheException(e);
		} catch (net.sf.ehcache.CacheException e){
			throw new CacheException(e);
		}
	}

	public void update(Object key, Object value) throws CacheException {
		put(key,value);
	}

}
