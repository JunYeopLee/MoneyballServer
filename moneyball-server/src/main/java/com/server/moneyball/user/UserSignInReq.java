package com.server.moneyball.user;

public class UserSignInReq {

	private String id;
	public String pw;
	private int kindOfSNS;

	public UserSignInReq() {
		super();
	}

	public UserSignInReq(String id, String pw, int kindOfSNS) {
		super();
		this.id = id;
		this.pw = pw;
		this.kindOfSNS = kindOfSNS;
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

	public int getKindOfSNS() {
		return kindOfSNS;
	}

	public void setKindOfSNS(int kindOfSNS) {
		this.kindOfSNS = kindOfSNS;
	}

}
