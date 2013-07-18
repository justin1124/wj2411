package com.wj2411.lottery.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wj2411.lottery.common.cache.CacheManager;
import com.wj2411.lottery.model.Ssq;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SsqServiceTest {
	private static final Logger log = LoggerFactory.getLogger(SsqServiceTest.class);
	
	@Autowired
	private LotteryService ssqService;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInit(){
		log.debug("Test SsqService");
		ssqService.init();
		List<Ssq> ssqList = (List<Ssq>)CacheManager.get("ssq", "redBalls");
		log.debug("Ssq num : "+ssqList.size());
	}
}
