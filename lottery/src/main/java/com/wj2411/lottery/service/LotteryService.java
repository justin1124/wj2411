package com.wj2411.lottery.service;

/**
 * 彩票统一接口定义
 * @author 须俊杰
 * @version 1.0 2012-7-11
 */
public interface LotteryService {
	/**
	 * 初始化
	 */
	void init();
	
	/**
	 * 同步
	 */
	void sync();
}