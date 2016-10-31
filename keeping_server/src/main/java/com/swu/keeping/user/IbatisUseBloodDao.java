package com.swu.keeping.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class IbatisUseBloodDao extends SqlMapClientDaoSupport implements
		UseBloodDao {

	@Transactional
	@Override
	public int useBlood(String bloodId, String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bloodId", bloodId);
		paramMap.put("userId", userId);
		getSqlMapClientTemplate().update("UseBlood.updateBloodTB", paramMap);
		getSqlMapClientTemplate().update("UseBlood.updateUserTB", paramMap);
		return 1;
	}

}
