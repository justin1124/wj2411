package com.lottery.common.cache;

import java.util.Hashtable;

import net.sf.ehcache.CacheManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EhCacheProvider implements CacheProvider {

	private static final Log log = LogFactory.getLog(EhCacheProvider.class);  
	
	private net.sf.ehcache.CacheManager cacheManager;
	private Hashtable<String, Ehcache> _cacheManager;
	
	/**
	 * Builds a Cache.  
	 * @param name the name of the cache. Must match a cache configured in ehcache.xml
	 */
	public Cache buildCache(String regionName)
			throws CacheException {
		Ehcache ehcache = _cacheManager.get(regionName);
		if(ehcache == null){
			try {
				net.sf.ehcache.Cache cache = cacheManager.getCache(regionName);
				if(cache == null){
					log.warn("Could not find configure ["+regionName+"];using defaults");
					cacheManager.addCache(regionName);
					cache = cacheManager.getCache(regionName);
					log.debug("started Ehcache region : "+regionName);
				}
				synchronized (_cacheManager) {
					ehcache = new Ehcache(cache);
					_cacheManager.put(regionName, ehcache);
					return ehcache;
				}
			} catch (net.sf.ehcache.CacheException e) {
				throw new CacheException(e);
			}
		}
		return ehcache;
	}

	public void start() throws CacheException {
		if(cacheManager != null){
			return;
		}
		cacheManager = new CacheManager();
		_cacheManager = new Hashtable<String, Ehcache>();
	}

	public void stop() throws CacheException {
		if(cacheManager != null){
			cacheManager.shutdown();
			cacheManager = null;
		}
	}

}
