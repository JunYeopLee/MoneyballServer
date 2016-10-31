package com.swu.keeping.user;


public interface UserService {

	public UserVO authenticate(String id, String encryptPw) ;
	public void signUpUser(UserSignUpReq userSignUpReq);
	public void donateBlood(DonateReq donateReq);
	public void useBlood(String bloodId, String userID);
	public void registBlood(RegistBloodReq registBloodReq);
}
