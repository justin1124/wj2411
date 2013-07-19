package com.wj2411.lottery.service.impl;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wj2411.lottery.common.PropertyConfigurer;
import com.wj2411.lottery.service.CrawlerService;

/**
 * 爬虫
 * @author 须俊杰
 * @version 1.0 2013-7-19
 */
@Service("crawlerService")
public class CrawlerServiceImpl implements CrawlerService {

	private static final Logger log = LoggerFactory.getLogger(CrawlerServiceImpl.class);

	@Override
	public void crawling() {
		String ssqWinningNumbersUrl = PropertyConfigurer.getProperty("ssq_winning_numbers_url");
		log.debug("ssq_winning_numbers_url : " + ssqWinningNumbersUrl);
		
		/* parse ssq winning numbers page and get title content*/
		try {
			Parser parser = new Parser(ssqWinningNumbersUrl);
			TagNameFilter filter = new TagNameFilter("title");
			NodeList nl = parser.extractAllNodesThatMatch(filter);
			String title = nl.elementAt(0).toPlainTextString();
			log.debug("title : "+title);
			
			// get winning number and issue
			String issue = title.substring(4, 11);
			String winningNumber = title.substring(18,32);
			log.info("issue : "+issue+" , winningNumber : "+winningNumber);
			
			
		} catch (Exception e) {
			log.error("parse ssq winning numbers page error.",e);
		}
	}
}
