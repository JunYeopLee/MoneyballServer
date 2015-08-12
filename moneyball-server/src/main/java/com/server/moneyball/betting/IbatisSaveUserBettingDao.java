package com.server.moneyball.betting;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class IbatisSaveUserBettingDao extends SqlMapClientDaoSupport implements SaveUserBettingDao {

	@Transactional
	@Override
	public void insertUserBetting(UserBettingReq userBettingReq) {
		getSqlMapClientTemplate().insert("Betting.insertUserBetting", userBettingReq);
	}

}
