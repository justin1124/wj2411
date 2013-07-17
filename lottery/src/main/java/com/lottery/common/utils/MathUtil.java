package com.lottery.common.utils;

import java.util.List;

/**
 * 数学工具
 * 
 * @author 须俊杰
 * @version 1.0 2012-7-9
 */
public class MathUtil {

	/**
	 * M选N算法
	 * 
	 * @param data
	 * @param m
	 * @param n
	 * @param count
	 * @param result 所有组合列表
	 */
	public static void combine(int[] data, int m, int n, int count,
			List<int[]> result) {
		if (n == 0) { // 递归退出条件
			result.add(data.clone());
			return;
		}
		for (int i = m - n; i >= 0; --i) {
			data[count++] = m - i;
			combine(data, m - i - 1, n - 1, count, result);
			--count;
		}
	}
}
