package com.server.moneyball.unlock;

import org.apache.shiro.authc.AuthenticationException;

import com.server.moneyball.user.UserVO;

public class UnlockServiceImpl implements UnlockService {

	UnlockDao unlockDao;
	
	@Override
	public int unlock(UnlockReq unlockReq) {
		UserVO userVO;
		userVO = unlockDao.selectUserMoney(unlockReq);
		if(isMoneyEnough(userVO, unlockReq.getSubtractMoney())){
			userVO = unlockDao.subtractMoneyBall(unlockReq.getSubtractMoney());
			unlockDao.unlockTB(unlockReq);
			return userVO.getMoney();
		}else{
			throw new AuthenticationException("잔여머니볼이 부족합니다. 현재 잔여머니볼:"+ userVO.getMoney());
		}
		
	}

	public boolean isMoneyEnough(UserVO userVO, int subtractMoney) {
		int nowUserMoney = userVO.getMoney();
		boolean check = true;
		if(nowUserMoney - subtractMoney <= 0){
			check = false;
		}
		return check;
	}

}
