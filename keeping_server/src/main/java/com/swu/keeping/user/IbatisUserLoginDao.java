package com.swu.keeping.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class IbatisUserLoginDao extends SqlMapClientDaoSupport implements
		UserLoginDao {
	@SuppressWarnings("unchecked")
	@Override
	public UserVO findOne(String id, String pw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("pw", pw);
		UserVO userVO = (UserVO) getSqlMapClientTemplate().queryForObject(
				"UserLogin.findOne", paramMap);
		return userVO;

	}


}
