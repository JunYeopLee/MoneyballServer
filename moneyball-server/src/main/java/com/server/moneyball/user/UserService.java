package com.server.moneyball.user;

public interface UserService {

	public UserVO authenticate(String id, String pw, int kindOfSNS);
	public void signInUser(UserSignInReq userSignInReq);
	public boolean duplicationId(String id);
	void modifyPassword(String id, int kindOfSNS, int userNum,
			String newPassword, String oldPassword);



}
