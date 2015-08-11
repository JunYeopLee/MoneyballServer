package com.server.moneyball.user;

public interface UserSignUpDao {

	public void procedure_insertUlockTB(UserSignUpReq userSignUpReq);

	public UserVO findId(String id);

	public void insertUser(UserSignUpReq userSignUpReq);

}
