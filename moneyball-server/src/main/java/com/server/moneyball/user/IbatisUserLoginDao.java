package com.server.moneyball.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.server.moneyball.user.UserLoginDao;

public class IbatisUserLoginDao extends SqlMapClientDaoSupport implements
		UserLoginDao {
	@SuppressWarnings("unchecked")
	@Override
	public UserVO findOne(String id, int kindOfSNS) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("kindOfSNS", kindOfSNS);
		UserVO userVO = (UserVO) getSqlMapClientTemplate().queryForObject(
				"UserLogin.findOne", paramMap);
		return userVO;

	}

	@Transactional
	@Override
	public void updateMoneyByAttendance(String id, int kindOfSNS) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("kindOfSNS", kindOfSNS);
		getSqlMapClientTemplate().update("UserLogin.updateMoneyByAttendance",
				paramMap);
	}

}
