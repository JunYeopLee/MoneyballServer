package com.server.moneyball.unlock;

import org.apache.shiro.authc.AuthenticationException;

import com.server.moneyball.user.UserVO;

public class UnlockServiceImpl implements UnlockService {

	UnlockDao unlockDao;

	@Override
	public UnlockVO unlock(UnlockReq unlockReq) {
		UnlockVO unlockVO;
		unlockVO = unlockDao.selectUserMoney(unlockReq);
		if (isMoneyEnough(unlockVO, unlockReq.getSubtractMoney())) {
			int userMoney = unlockVO.getPreSubtractmoney() - unlockReq.getSubtractMoney();
			unlockDao.subtractMoneyBall(unlockVO.getUserNum(), userMoney);
			unlockDao.unlockTB(unlockReq);
			unlockVO.setUserMoneyResult(userMoney);
			return unlockVO;
		} else {
			throw new AuthenticationException("잔여머니볼이 부족합니다. 현재 잔여머니볼:"
					+ unlockVO.getPreSubtractmoney());
		}

	}

	public boolean isMoneyEnough(UnlockVO userVO, int subtractMoney) {
		int nowUserMoney = userVO.getPreSubtractmoney();
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
