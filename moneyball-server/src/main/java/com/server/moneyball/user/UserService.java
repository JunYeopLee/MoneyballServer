package com.server.moneyball.user;

public interface UserService {


	public int insertUser(UserSignInReq userSignInReq);

	public UserVO insertUserSNS(String id, String pw, int kindOfSNS);

	public UserVO authenticate(String id, String pw, int kindOfSNS);



}
