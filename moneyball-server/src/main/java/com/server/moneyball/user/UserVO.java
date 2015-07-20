package com.server.moneyball.user;

public class UserVO {

	String id;
	String pw;
	int userNum;
	int kindOfSNS;
	int money;

	public UserVO() {
		super();
	}

	public UserVO(String id, String pw, int userNum, int kindOfSNS, int money) {
		super();
		this.id = id;
		this.pw = pw;
		this.userNum = userNum;
		this.kindOfSNS = kindOfSNS;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getKindOfSNS() {
		return kindOfSNS;
	}

	public void setKindOfSNS(int kindOfSNS) {
		this.kindOfSNS = kindOfSNS;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isPasswordEquals(String pw) {
		if (this.pw == null) {
			return false;
		}
		return this.pw.compareTo(pw) == 0;
	}

	public void changePassword(String newPassword, String oldPassword)
			throws PasswordNotMatchingException {
		if (!this.pw.equals(oldPassword)) {
			throw new PasswordNotMatchingException();
		}
		this.pw = newPassword;
	}

}
