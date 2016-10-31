package com.swu.keeping.user;

public class UserVO {
	String id;
	String pw;
	String name;
	String idNo;
	String bloodType;
	String job;

	public UserVO() {
		super();
	}

	public UserVO(String id, String pw, String name, String idNo,
			String bloodType, String job) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.idNo = idNo;
		this.bloodType = bloodType;
		this.job = job;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public boolean isPasswordEquals(String pw) {
		if (this.pw == null) {
			return false;
		}
		return this.pw.compareTo(pw) == 0;
	}

}
