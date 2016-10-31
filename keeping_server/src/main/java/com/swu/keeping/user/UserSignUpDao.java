package com.swu.keeping.user;

public interface UserSignUpDao {


	public UserVO findId(String id);

	public void insertUser(UserSignUpReq userSignUpReq);

}
