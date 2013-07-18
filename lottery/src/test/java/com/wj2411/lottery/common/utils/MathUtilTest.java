package com.wj2411.lottery.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MathUtilTest {

	private static final Logger log = LoggerFactory.getLogger(MathUtilTest.class);

	@Test
	public void testCombine() {
		List<int[]> data = new ArrayList<int[]>();
		MathUtil.combine(new int[6], 33, 6, 0, data);

		// 翻转数组元素排列次序
		ArrayUtils.reverse(data.get(0));

		log.debug("Ssq red ball number = {}", data.size());
		log.debug("The first ssq red ball number : {}", data.get(0));
	}
}
