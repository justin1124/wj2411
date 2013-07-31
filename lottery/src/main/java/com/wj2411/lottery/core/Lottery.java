package com.wj2411.lottery.core;

import java.util.List;

import com.wj2411.lottery.controller.support.SsqForm;

/**
 * 彩票统一接口定义
 * @author 须俊杰
 * @version 1.0 2012-7-11
 */
public interface Lottery {
	/**
	 * 初始化
	 */
	void init();
	
	/**
	 * 同步
	 */
	void sync();
	
	/**
	 * 计算
	 */
	List<int[]> calculate(SsqForm ssqForm);
}
