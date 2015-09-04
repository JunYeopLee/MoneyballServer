package com.server.moneyball.user;

import com.server.moneyball.user.UserVO;
import com.server.moneyball.user.UserVOList;

public interface UserLoginDao {
	public UserVO findOne(String id, int kindOfSNS);

	public void updateMoneyByAttendance(String id, int kindOfSNS); 

}
