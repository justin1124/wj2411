package com.lottery.common.cache;

import net.sf.ehcache.CacheException;

/**
 * @ClassName: Cache
 * @Description: 缓存接口
 * @author 杰然不同
 * @date 2010-11-24
 */
public interface Cache {

	
	/**
	 * @Title: get
	 * @Description: Get an item from the cache
	 * @param key
	 * @return the cached object or null
	 * @throws CacheException
	 */
	public Object get(Object key) throws CacheException;
	
	/**
	 * @Title: put
	 * @Description: Add an item to the cache
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void put(Object key , Object value) throws CacheException;
	
	/**
	 * @Title: update
	 * @Description: Update an item from cache
	 * @param key
	 * @param value
	 * @throws CacheException
	 */
	public void update(Object key , Object value) throws CacheException;
	
	/**
	 * @Title: remove
	 * @Description: Remove an item from cache
	 * @param key
	 * @throws CacheException
	 */
	public void remove(Object key) throws CacheException;
}
