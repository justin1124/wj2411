package com.wj2411.lottery.common.utils;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilTest {
	private static final Logger log = LoggerFactory.getLogger(FileUtilTest.class);
	
	@Test
	public void testRead() throws IOException{
		ByteBuffer file = FileUtil.read("winning_numbers.txt");
		String fileContent = new String(file.array(),"UTF-8");
		log.info("content : "+fileContent);
		log.info("\\r index : "+fileContent.indexOf("\r\n"));
		log.info("4 index : "+fileContent.indexOf("4"));
	}
}
