package com.lottery.common.cache;

/**
 * @ClassName: CacheProvider
 * @Description: Support for pluggable caches
 * @author 杰然不同
 * @date 2010-11-24
 */
public interface CacheProvider {

	/**
	 * @Title: buildCache
	 * @Description: Configure the cache
	 * @param regionName the name of the cache region
	 * @throws CacheException
	 */
	public Cache buildCache(String regionName) throws CacheException;
	
	/**
	 * @Title: start
	 * @Description: Callback to perform any necessary initialization of the underlying cache implementation 
	 * during SessionFactory construction 
	 * @throws CacheException
	 */
	public void start() throws CacheException;
	
	/**
	 * @Title: stop
	 * @Description: Callback to perform any necessary cleanup of the underlying cache implementation 
	 * during SessionFactory.close()
	 * @throws CacheException
	 */
	public void stop() throws CacheException;
}
