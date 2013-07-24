package com.wj2411.lottery.core.crawler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wj2411.lottery.common.PropertyConfigurer;
import com.wj2411.lottery.core.crawler.Crawler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CrawlerTest {

	@Autowired
	private Crawler ssqCrawler;
	
	@Test
	public void testCrawling(){
		String ssqWinningNumbersUrl = PropertyConfigurer.getProperty("ssq_winning_numbers_url");
		ssqCrawler.crawling(ssqWinningNumbersUrl);
	}
}
