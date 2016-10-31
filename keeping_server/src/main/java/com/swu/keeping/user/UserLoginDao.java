package com.swu.keeping.user;

public interface UserLoginDao {

	public UserVO findOne(String id, String pw); 

}
