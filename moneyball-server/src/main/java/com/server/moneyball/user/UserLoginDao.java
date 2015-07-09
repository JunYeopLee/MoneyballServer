package com.server.moneyball.user;

import com.server.moneyball.user.UserVO;
import com.server.moneyball.user.UserVOList;

public interface UserLoginDao {

	public UserVO selectUserInfo(String id, String pw, int kindofsns);

	public UserVO findUser(String id, int kindOfSNS); 

}
