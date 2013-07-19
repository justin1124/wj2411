package com.wj2411.lottery.common.utils;

import org.junit.Test;

public class HttpUtilTest {

	@Test
	public void testGet(){
		HttpUtil.get("http://www.baidu.com");
	}
}
