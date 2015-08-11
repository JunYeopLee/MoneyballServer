package com.server.moneyball.unlock;

import com.server.moneyball.user.UserVO;

public interface UnlockDao {
	public UserVO selectUserMoney(UnlockReq unlockReq);

	public void subtractMoneyBall(int userNum, int subtractMoney);

	public void unlockTB(UnlockReq unlockReq);
}
