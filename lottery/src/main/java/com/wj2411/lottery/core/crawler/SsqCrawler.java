package com.wj2411.lottery.core.crawler;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wj2411.lottery.core.support.WinningInfo;

/**
 * 爬虫
 * @author 须俊杰
 * @version 1.0 2013-7-19
 */
@Service
public class SsqCrawler implements Crawler {

	private static final Logger log = LoggerFactory.getLogger(SsqCrawler.class);

	@Override
	public WinningInfo crawling(String url) {
		log.debug("url : " + url);
		WinningInfo winningInfo = new WinningInfo();
		/* parse winning numbers page and get title content*/
		try {
			Parser parser = new Parser(url);
			TagNameFilter filter = new TagNameFilter("title");
			NodeList nl = parser.extractAllNodesThatMatch(filter);
			String title = nl.elementAt(0).toPlainTextString();
			log.debug("title : "+title);
			
			// get winning number and issue
			winningInfo.setIssue(Integer.parseInt(title.substring(4, 11)));
			winningInfo.setNumber(title.substring(18,32));
			log.info("issue : "+winningInfo.getIssue()+" , winningNumber : "+winningInfo.getNumber());
			
			return winningInfo;
		} catch (Exception e) {
			log.error("parse ssq winning numbers page error.",e);
		}
		return null;
	}
}
