package com.lottery.common.cache;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Description: 缓存管理
 * @author 杰然不同
 * @date 2010-11-24
 */
public class CacheManager {
	private final static Log log = LogFactory.getLog(CacheManager.class);
	private static CacheProvider provider;  

	static{
		initCacheProvider("com.lottery.common.cache.EhCacheProvider");
	}
	
	private static void initCacheProvider(String prv_name){
		try {
			provider = (CacheProvider)Class.forName(prv_name).newInstance();
			provider.start();
			log.info("Using CacheProvider : "+provider.getClass().getName());
		} catch (Exception e) {
			provider = new EhCacheProvider();
		}
	}
	
	private final static Cache _GetCache(String cache_name){
		if(provider == null)
			provider = new EhCacheProvider();
		return provider.buildCache(cache_name);
	}
	
	/**
	 * @Description: 获取缓存中的数据
	 * @param name
	 * @param key
	 * @return
	 */
	public final static Object get(String name , Serializable key){
		if(name != null && key != null)
			return _GetCache(name).get(key);
		return null;
	}
	
	/**
	 * @Description: 获取缓存中的数据
	 * @param <T>
	 * @param resultClass
	 * @param name
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T get(Class<T> resultClass , String name , Serializable key){
		if(name != null && key != null)
			return (T)_GetCache(name).get(key);
		return null;
	}
	
	/**
	 * @Description: 写入缓存
	 * @param name
	 * @param key
	 * @param value
	 */
	public final static void set(String name , Serializable key , Serializable value){
		if(name != null && key != null && value != null)
			 _GetCache(name).put(key, value);
	}
	
	/**
	 * @Description: 清除缓存中的某个数据
	 * @param name
	 * @param key
	 */
	public final static void remove(String name , Serializable key){
		if(name != null && key != null)
			_GetCache(name).remove(key);
	}
}
