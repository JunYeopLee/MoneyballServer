package com.swu.keeping.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class IbatisUserSignUpDao extends SqlMapClientDaoSupport implements
		UserSignUpDao {
	
	@Transactional
	@Override
	public void insertUser(UserSignUpReq userSignUpReq) {
		getSqlMapClientTemplate().insert("UserSignUp.insertUser", userSignUpReq);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserVO findId(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		UserVO userVO = (UserVO) getSqlMapClientTemplate().queryForObject(
				"UserSignUp.findId", paramMap);
		return userVO;
	}


}
