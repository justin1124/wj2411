package com.wj2411.lottery.model;

/**
 * 开奖信息
 * @author 须俊杰
 * @version 1.0 2013-7-19
 */
public class WinningInfo {

	/**
	 * 期号
	 */
	private int issue;
	/**
	 * 号码
	 */
	private String number;
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
