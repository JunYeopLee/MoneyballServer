package com.server.moneyball.unlock;

public class UnlockVO {

	String id;
	int userNum;
	int preSubtractmoney;
	String score;
	int userMoneyResult;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getPreSubtractmoney() {
		return preSubtractmoney;
	}

	public void setPreSubtractmoney(int preSubtractmoney) {
		this.preSubtractmoney = preSubtractmoney;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getUserMoneyResult() {
		return userMoneyResult;
	}

	public void setUserMoneyResult(int userMoneyResult) {
		this.userMoneyResult = userMoneyResult;
	}

}