package com.wj2411.lottery.model;

/**
 * 双色球计算参数
 * @author 须俊杰
 * @version 1.0 2013-7-22
 */
public class SsqParam {
	private Integer issue;				// 期号
	private Integer minMissingValue;	// 最小遗漏和
	private Integer maxMissingValue;	// 最大遗漏和
	private Integer oddNum;				// 奇数个数
	private Integer minSumTail;			// 最小尾和
	private Integer maxSumTail;			// 最大尾和
	private Integer min;				// 最小和值
	private Integer max;				// 最大和值
	private Integer horizontalLink;		// 是否横连
	private Integer verticalLink;		// 是否竖连
	private String range;				// 区间比
	private Integer primeNum;			// 质数个数

	public Integer getIssue() {
		return issue;
	}
	public void setIssue(Integer issue) {
		this.issue = issue;
	}
	public Integer getOddNum() {
		return oddNum;
	}
	public void setOddNum(Integer oddNum) {
		this.oddNum = oddNum;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getHorizontalLink() {
		return horizontalLink;
	}
	public void setHorizontalLink(Integer horizontalLink) {
		this.horizontalLink = horizontalLink;
	}
	public Integer getVerticalLink() {
		return verticalLink;
	}
	public void setVerticalLink(Integer verticalLink) {
		this.verticalLink = verticalLink;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public Integer getPrimeNum() {
		return primeNum;
	}
	public void setPrimeNum(Integer primeNum) {
		this.primeNum = primeNum;
	}
	public Integer getMinMissingValue() {
		return minMissingValue;
	}
	public void setMinMissingValue(Integer minMissingValue) {
		this.minMissingValue = minMissingValue;
	}
	public Integer getMaxMissingValue() {
		return maxMissingValue;
	}
	public void setMaxMissingValue(Integer maxMissingValue) {
		this.maxMissingValue = maxMissingValue;
	}
	public Integer getMinSumTail() {
		return minSumTail;
	}
	public void setMinSumTail(Integer minSumTail) {
		this.minSumTail = minSumTail;
	}
	public Integer getMaxSumTail() {
		return maxSumTail;
	}
	public void setMaxSumTail(Integer maxSumTail) {
		this.maxSumTail = maxSumTail;
	}
}
