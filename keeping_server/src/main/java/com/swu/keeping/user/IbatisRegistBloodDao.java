package com.swu.keeping.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class IbatisRegistBloodDao extends SqlMapClientDaoSupport implements
		RegistBloodDao {

	@Transactional
	@Override
	public int registBlood(RegistBloodReq registBloodReq) {
		getSqlMapClientTemplate().insert("RegistBlood.insertBloodTB",
				registBloodReq);
		getSqlMapClientTemplate().update("RegistBlood.updateUserTB_1",
				registBloodReq);
		getSqlMapClientTemplate().update("RegistBlood.updateUserTB_2",
				registBloodReq);
		return 1;
	}

}
