package com.swu.keeping.user;

public class UserSignUpReq {

	String id;
	String pw;
	String name;
	String idNo;
	String bloodType;
	String job;

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getIdNo() {
		return idNo;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getJob() {
		return job;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
