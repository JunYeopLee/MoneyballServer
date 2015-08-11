package com.server.moneyball.unlock;

public class UnlockReq {

	// userNum=21&matchNum=1&unlockNum=3
	int userNum;
	int matchNum;
	int unlockNum;
	int subtractMoney;

	public int getSubtractMoney() {
		if (this.unlockNum == 3) { // 3번 좌물쇠 열기
			this.subtractMoney = 300; // 300 머니볼 차감
			return subtractMoney;
		} else if (this.unlockNum == 4) {
			this.subtractMoney = 400;
			return subtractMoney;
		} else if (this.unlockNum == 5) {
			this.subtractMoney = 500;
			return subtractMoney;
		} else {
			return subtractMoney = 0;
		}
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}

	public void setUnlockNum(int unlockNum) {
		this.unlockNum = unlockNum;
	}

	public void setSubtractMoney(int subtractMoney) {
		this.subtractMoney = subtractMoney;
	}

	public int getUserNum() {
		return userNum;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public int getUnlockNum() {
		return unlockNum;
	}

}
