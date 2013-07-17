package com.lottery.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lottery.common.cache.CacheManager;
import com.lottery.common.utils.MathUtil;
import com.lottery.model.Ssq;
import com.lottery.service.LotteryService;

@Service("ssqService")
public class SsqServiceImpl implements LotteryService {

	private static final Logger log = LoggerFactory.getLogger(SsqServiceImpl.class);
	
	@Override
	public void init() {
		log.info("初始化双色球服务");
		
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
			
			for(int ball : redBalls){
				// 奇数计算
				if(ball % 2 != 0)
					oddNum++;
				
				// 尾和统计
				unitsDigitSum += ball % 10;
				
				// 和值计算
				redBallSum += ball;
				
				// 计算区间个数
				if (ball <= 11)
					range1++;
				else if (ball > 11 && ball <= 22)
					range2++;
				else
					range3++;
				
				// 质数个数
				if(ball == 1 || ball == 2 
						|| ball == 3 
						|| ball == 5 
						|| ball == 7 
						|| ball == 11 
						|| ball == 13 
						|| ball == 17 
						|| ball == 19 
						|| ball == 23 
						|| ball == 29 
						|| ball == 31)
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
		CacheManager.set("ssq", "redBalls", (Serializable)ssqList);
		log.info("初始化双色球服务完毕");
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
}
