package com.lottery.common.utils;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilTest {
	private static final Logger log = LoggerFactory.getLogger(FileUtilTest.class);
	
	@Test
	public void testRead() throws IOException{
		FileUtil.read("winning_numbers.txt");
	}
}
