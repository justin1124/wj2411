package com.wj2411.lottery.core;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wj2411.lottery.common.PropertyConfigurer;
import com.wj2411.lottery.common.cache.CacheManager;
import com.wj2411.lottery.common.utils.FileUtil;
import com.wj2411.lottery.common.utils.MathUtil;
import com.wj2411.lottery.core.crawler.Crawler;
import com.wj2411.lottery.core.support.Ssq;
import com.wj2411.lottery.core.support.WinningInfo;

@Service("ssqService")
public class SsqService implements Lottery,InitializingBean {

	private static final Logger log = LoggerFactory.getLogger(SsqService.class);
	private static final String SSQWINNINGNUMBERSFILENAME = "ssq_winning_numbers.txt";
	@Autowired
	private Crawler crawlerService;
	
	@Override
	public void sync() {
		try {
			// 获取最新开奖号码
			String ssqWinningNumbersUrl = PropertyConfigurer.getProperty("ssq_winning_numbers_url");
			WinningInfo lastWinningInfo = crawlerService.crawling(ssqWinningNumbersUrl);
			
			// 获取本地最新的开奖信息
			ByteBuffer file = FileUtil.read(SSQWINNINGNUMBERSFILENAME);
			String fileContent = new String(file.array(),"UTF-8");
			
			int firstLineEndingIndex = fileContent.indexOf("\r\n");
			String firstLineContent = fileContent.substring(0,firstLineEndingIndex);
			int issue = Integer.parseInt(firstLineContent.split(",")[0]);
			log.info("本地最新的期数: "+issue);
			
			// 同步缺失的开奖信息		
			if(issue < lastWinningInfo.getIssue()){
				StringBuilder sb = new StringBuilder();
				for (int i = lastWinningInfo.getIssue(); i > issue; i--) {
					WinningInfo winningInfo = crawlerService.crawling(ssqWinningNumbersUrl+"/"+i);
					sb.append(winningInfo.getIssue()+","+winningInfo.getNumber()+"\r\n");
				}
				sb.append(fileContent);
				// 写入开奖信息
				ByteBuffer contentBuffer = ByteBuffer.wrap(sb.toString().getBytes("UTF-8"));
				FileUtil.write(SSQWINNINGNUMBERSFILENAME, contentBuffer);
				
				// 计算遗漏值
				calculateMissingValue(sb.toString());
			}
		} catch (IOException e) {
			log.error("读取文件异常");
		}
	}
	
	@Override
	public void init() {
		log.info("开始初始化双色球");
		long start = System.currentTimeMillis();
		
		List<Ssq> ssqList = new ArrayList<Ssq>();
		
		List<int[]> data = create();
		
		// 构建号码，计算号码组合的固定属性
		for(int[] redBalls : data){
			int oddNum = 0;				// 奇数个数
			int unitsDigitSum = 0;		// 尾和
			int redBallSum = 0;			// 和值
			int range1 = 0;				// 区间1个数
			int range2 = 0;				// 区间2个数
			int range3 = 0;				// 区间3个数
			int	primeNum = 0;			// 质数个数
			
			for(int redBall : redBalls){
				// 奇数计算
				if(redBall % 2 != 0)
					oddNum++;
				
				// 尾和统计
				unitsDigitSum += redBall % 10;
				
				// 和值计算
				redBallSum += redBall;
				
				// 计算区间个数
				if (redBall <= 11)
					range1++;
				else if (redBall > 11 && redBall <= 22)
					range2++;
				else
					range3++;
				
				// 质数个数
				if(redBall == 1 || redBall == 2 
						|| redBall == 3 
						|| redBall == 5 
						|| redBall == 7 
						|| redBall == 11 
						|| redBall == 13 
						|| redBall == 17 
						|| redBall == 19 
						|| redBall == 23 
						|| redBall == 29 
						|| redBall == 31)
					primeNum++;
			}
			
			ArrayUtils.reverse(redBalls);	// 翻转数组元素排列次序
			
			Ssq ssq = new Ssq();
			ssq.setRedBalls(redBalls);
			ssq.setOddNum(oddNum);
			ssq.setRedBallSum(redBallSum);
			ssq.setRange1(range1);
			ssq.setRange2(range2);
			ssq.setRange3(range3);
			ssq.setUnitsDigitSum(unitsDigitSum);
			ssq.setPrimeNum(primeNum);
			
			ssqList.add(ssq);
		}
		CacheManager.set("lotteryCache", "redBalls", (Serializable)ssqList);
		log.info("初始化双色球完毕,耗时:"+(System.currentTimeMillis() - start)+"ms");
	}

	/**
	 * 计算双色球所有红球组合
	 */
	private List<int[]> create() {
		log.info("开始创建双色球所有红球组合");
		List<int[]> data = new ArrayList<int[]>();
		MathUtil.combine(new int[6], 33, 6, 0, data);
		log.info("双色球所有红球组合创建完毕，总数 : " + data.size());
		return data;
	}

	/**
	 * 计算遗漏值
	 */
	private void calculateMissingValue(String winningNumbers){
		log.info("开始计算遗漏值");
		long start = System.currentTimeMillis();
		
		int[] missingValue = new int[33];
		String[] numbers = winningNumbers.split("\r\n");
		for(String number : numbers){
			
		}
		
		CacheManager.set("lotteryCache", "missingValue", (Serializable)missingValue);
		log.info("遗漏值计算完成,耗时:"+(System.currentTimeMillis() - start)+"ms");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}
}