package com.swu.keeping.user;

public class UserBloodVO {
	String bloodID;
	String HUMAN_NAME;
	String BIRTH_DATE;
	String BLOOD_DATE;
	String BLOOD_LOC;
	String SENDER_ID;
	String BLOOD_AMOUNT;
	String BLOOD_SEX;
	String BLOOD_TYPE;
	String FIGHTING_MSG;
	int IS_USE;
	int IS_DONATE;

	public UserBloodVO() {
		super();
	}

	public UserBloodVO(String bloodID, String hUMAN_NAME, String bIRTH_DATE,
			String bLOOD_DATE, String bLOOD_LOC, String sENDER_ID,
			String bLOOD_AMOUNT, String bLOOD_SEX, String bLOOD_TYPE,
			String fIGHTING_MSG, int iS_USE, int iS_DONATE) {
		super();
		this.bloodID = bloodID;
		HUMAN_NAME = hUMAN_NAME;
		BIRTH_DATE = bIRTH_DATE;
		BLOOD_DATE = bLOOD_DATE;
		BLOOD_LOC = bLOOD_LOC;
		SENDER_ID = sENDER_ID;
		BLOOD_AMOUNT = bLOOD_AMOUNT;
		BLOOD_SEX = bLOOD_SEX;
		BLOOD_TYPE = bLOOD_TYPE;
		FIGHTING_MSG = fIGHTING_MSG;
		IS_USE = iS_USE;
		IS_DONATE = iS_DONATE;
	}

	public String getBloodID() {
		return bloodID;
	}

	public void setBloodID(String bloodID) {
		this.bloodID = bloodID;
	}

	public String getHUMAN_NAME() {
		return HUMAN_NAME;
	}

	public void setHUMAN_NAME(String hUMAN_NAME) {
		HUMAN_NAME = hUMAN_NAME;
	}

	public String getBIRTH_DATE() {
		return BIRTH_DATE;
	}

	public void setBIRTH_DATE(String bIRTH_DATE) {
		BIRTH_DATE = bIRTH_DATE;
	}

	public String getBLOOD_DATE() {
		return BLOOD_DATE;
	}

	public void setBLOOD_DATE(String bLOOD_DATE) {
		BLOOD_DATE = bLOOD_DATE;
	}

	public String getBLOOD_LOC() {
		return BLOOD_LOC;
	}

	public void setBLOOD_LOC(String bLOOD_LOC) {
		BLOOD_LOC = bLOOD_LOC;
	}

	public String getSENDER_ID() {
		return SENDER_ID;
	}

	public void setSENDER_ID(String sENDER_ID) {
		SENDER_ID = sENDER_ID;
	}

	public String getBLOOD_AMOUNT() {
		return BLOOD_AMOUNT;
	}

	public void setBLOOD_AMOUNT(String bLOOD_AMOUNT) {
		BLOOD_AMOUNT = bLOOD_AMOUNT;
	}

	public String getBLOOD_SEX() {
		return BLOOD_SEX;
	}

	public void setBLOOD_SEX(String bLOOD_SEX) {
		BLOOD_SEX = bLOOD_SEX;
	}

	public String getBLOOD_TYPE() {
		return BLOOD_TYPE;
	}

	public void setBLOOD_TYPE(String bLOOD_TYPE) {
		BLOOD_TYPE = bLOOD_TYPE;
	}

	public String getFIGHTING_MSG() {
		return FIGHTING_MSG;
	}

	public void setFIGHTING_MSG(String fIGHTING_MSG) {
		FIGHTING_MSG = fIGHTING_MSG;
	}

	public int getIS_USE() {
		return IS_USE;
	}

	public void setIS_USE(int iS_USE) {
		IS_USE = iS_USE;
	}

	public int getIS_DONATE() {
		return IS_DONATE;
	}

	public void setIS_DONATE(int iS_DONATE) {
		IS_DONATE = iS_DONATE;
	}

}
