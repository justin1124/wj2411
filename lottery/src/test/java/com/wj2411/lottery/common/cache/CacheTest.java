package com.wj2411.lottery.common.cache;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CacheTest {
	
	@Test
	public void testCache(){
		CacheManager.set("lotteryCache", "name", "JJ");
		
		Assert.assertEquals("JJ", CacheManager.get("lotteryCache", "name"));
		
	}
}
