package com.server.moneyball.unlock;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;


public class IbatisUnlockDao extends SqlMapClientDaoSupport implements UnlockDao {

	@SuppressWarnings("unchecked")
	@Override
	public UnlockVO selectUserMoney(UnlockReq unlockReq) {
				UnlockVO unlockVO = (UnlockVO) getSqlMapClientTemplate().queryForObject("Unlock.selectUserMoney", unlockReq);
		return unlockVO;	
		}
	
	@Transactional
	@Override
	public void subtractMoneyBall(int userNum, int userMoney) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNum", userNum);
		paramMap.put("userMoney", userMoney);
		getSqlMapClientTemplate().update("Unlock.subtractMoneyBall", paramMap);
	}


	@Transactional
	@Override
	public void unlockTB(UnlockReq unlockReq) {
		getSqlMapClientTemplate().update("Unlock.unlockTB", unlockReq);
		
	}


}
