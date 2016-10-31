package com.swu.keeping.user;

public class UserDetailVO {
	String name;
	String id;
	String bloodType;
	int doCnt;
	int getCnt;
	int giveCnt;
	String recentBloodDate;
	String nextBloodDate;

	public UserDetailVO() {
		super();
	}

	public UserDetailVO(String name, String id, String bloodType, int doCnt,
			int getCnt, int giveCnt, String recentBloodDate,
			String nextBloodDate) {
		super();
		this.name = name;
		this.id = id;
		this.bloodType = bloodType;
		this.doCnt = doCnt;
		this.getCnt = getCnt;
		this.giveCnt = giveCnt;
		this.recentBloodDate = recentBloodDate;
		this.nextBloodDate = nextBloodDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public int getDoCnt() {
		return doCnt;
	}

	public void setDoCnt(int doCnt) {
		this.doCnt = doCnt;
	}

	public int getGetCnt() {
		return getCnt;
	}

	public void setGetCnt(int getCnt) {
		this.getCnt = getCnt;
	}

	public int getGiveCnt() {
		return giveCnt;
	}

	public void setGiveCnt(int giveCnt) {
		this.giveCnt = giveCnt;
	}

	public String getRecentBloodDate() {
		return recentBloodDate;
	}

	public void setRecentBloodDate(String recentBloodDate) {
		this.recentBloodDate = recentBloodDate;
	}

	public String getNextBloodDate() {
		return nextBloodDate;
	}

	public void setNextBloodDate(String nextBloodDate) {
		this.nextBloodDate = nextBloodDate;
	}

}
