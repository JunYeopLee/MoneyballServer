package com.server.moneyball.unlock;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.server.moneyball.user.UserVO;

public class IbatisUnlockDao extends SqlMapClientDaoSupport implements UnlockDao {

	@SuppressWarnings("unchecked")
	@Override
	public UserVO selectUserMoney(UnlockReq unlockReq) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNum", unlockReq.getUserNum());
		UserVO userVO = (UserVO) getSqlMapClientTemplate().queryForObject("Unlock.selectUserMoney", paramMap);
		return userVO;	
		}
	
	@Transactional
	@Override
	public UserVO subtractMoneyBall(int subtractMoney) {
		// TODO Auto-generated method stub
		return null;
	}


	@Transactional
	@Override
	public void unlockTB(UnlockReq unlockReq) {
		// TODO Auto-generated method stub
		
	}


}
