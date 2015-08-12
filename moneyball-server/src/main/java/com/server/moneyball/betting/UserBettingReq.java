package com.server.moneyball.betting;

public class UserBettingReq {
	// userNum=#userNum#&betStates=#betStates#&betMoney=#betMoney#

	int userNum;
	String betStates;
	int betMoney;

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getBetStates() {
		return betStates;
	}

	public void setBetStates(String betStates) {
		this.betStates = betStates;
	}

	public int getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(int betMoney) {
		this.betMoney = betMoney;
	}

}
