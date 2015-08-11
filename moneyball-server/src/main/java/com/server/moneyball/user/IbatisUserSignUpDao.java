package com.server.moneyball.user;

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

	@Transactional
	@Override
	public void procedure_insertUlockTB(UserSignUpReq userSignUpReq) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pro_id", userSignUpReq.getId());
		paramMap.put("pro_pw", userSignUpReq.getPw());
		paramMap.put("pro_kind_of_sns_no", userSignUpReq.getKindOfSNS());
		getSqlMapClientTemplate()
				.update("UserSignUp.procedure_insertUlockTB", paramMap);
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
