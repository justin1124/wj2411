package com.wj2411.lottery.core.crawler;

import com.wj2411.lottery.core.support.WinningInfo;

/**
 * 爬虫服务
 * @author 须俊杰
 * @version 1.0 2013-7-18
 */
public interface Crawler {

	/**
	 * 爬取
	 */
	public WinningInfo crawling(String url);
}
