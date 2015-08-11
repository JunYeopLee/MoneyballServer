package com.server.moneyball.unlock;

import org.apache.shiro.authc.AuthenticationException;

import com.server.moneyball.user.UserVO;

public class UnlockServiceImpl implements UnlockService {

	UnlockDao unlockDao;

	@Override
	public int unlock(UnlockReq unlockReq) {
		UserVO userVO;
		userVO = unlockDao.selectUserMoney(unlockReq);
		if (isMoneyEnough(userVO, unlockReq.getSubtractMoney())) {
			int userMoney = userVO.getMoney() - unlockReq.getSubtractMoney();
			unlockDao.subtractMoneyBall(userVO.getUserNum(), userMoney);
			unlockDao.unlockTB(unlockReq);
			return userMoney;
		} else {
			throw new AuthenticationException("잔여머니볼이 부족합니다. 현재 잔여머니볼:"
					+ userVO.getMoney());
		}

	}

	public boolean isMoneyEnough(UserVO userVO, int subtractMoney) {
		int nowUserMoney = userVO.getMoney();
		boolean check = true;
		if (nowUserMoney - subtractMoney <= 0) {
			check = false;
		}
		return check;
	}

	public void setUnlockDao(UnlockDao unlockDao) {
		this.unlockDao = unlockDao;
	}

}
