package com.lottery.model;

import java.io.Serializable;

/**
 * 双色球
 * @author 须俊杰
 * @version 1.0 2012-7-12
 */
public class Ssq implements Serializable{

	private static final long serialVersionUID = 1L;
	private int[] redBalls;		// 红球
	private int blueBall;		// 蓝球
	private int oddNum;			// 奇数个数
	private int unitsDigitSum;	// 尾和
	private int redBallSum;		// 红球总和
	private int range1;			// 区间1个数
	private int range2;			// 区间2个数
	private int range3;			// 区间3个数
	private int primeNum;		// 质数个数
	
	public int[] getRedBalls() {
		return redBalls;
	}
	public void setRedBalls(int[] redBalls) {
		this.redBalls = redBalls;
	}
	public int getBlueBall() {
		return blueBall;
	}
	public void setBlueBall(int blueBall) {
		this.blueBall = blueBall;
	}
	public int getOddNum() {
		return oddNum;
	}
	public void setOddNum(int oddNum) {
		this.oddNum = oddNum;
	}
	public int getUnitsDigitSum() {
		return unitsDigitSum;
	}
	public void setUnitsDigitSum(int unitsDigitSum) {
		this.unitsDigitSum = unitsDigitSum;
	}
	public int getRedBallSum() {
		return redBallSum;
	}
	public void setRedBallSum(int redBallSum) {
		this.redBallSum = redBallSum;
	}
	public int getRange1() {
		return range1;
	}
	public void setRange1(int range1) {
		this.range1 = range1;
	}
	public int getRange2() {
		return range2;
	}
	public void setRange2(int range2) {
		this.range2 = range2;
	}
	public int getRange3() {
		return range3;
	}
	public void setRange3(int range3) {
		this.range3 = range3;
	}
	public int getPrimeNum() {
		return primeNum;
	}
	public void setPrimeNum(int primeNum) {
		this.primeNum = primeNum;
	}
}
