package com.wj2411.lottery.common.cache;

@SuppressWarnings("serial")
public class CacheException extends RuntimeException {
	
	public CacheException(String s){
		super(s);
	}
	
	public CacheException(String s,Throwable e){
		super(s,e);
	}
	
	public CacheException(Throwable e){
		super(e);
	}
}
