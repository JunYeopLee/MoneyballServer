package com.swu.keeping.user;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class IbatisDonateBloodDao extends SqlMapClientDaoSupport implements
		DonateBloodDao {

	@Transactional
	@Override
	public void updateDonate(DonateReq donateReq) {
		getSqlMapClientTemplate().update("DonateBlood.updateBloodTB",
				donateReq);
		getSqlMapClientTemplate().update("DonateBlood.updateUserTB_1",
				donateReq);
		getSqlMapClientTemplate().update("DonateBlood.updateUserTB_2",
				donateReq);
	}

}
