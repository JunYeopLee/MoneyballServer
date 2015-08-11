package com.server.moneyball.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;


public class IbatisUserModifyDao extends SqlMapClientDaoSupport implements
		UserModifyDao {

	@Transactional
	@Override
	public int modyfyUserPw(int userNum, String pw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNum", userNum);
		paramMap.put("pw", pw);
		getSqlMapClientTemplate().queryForObject("UserModify.modifyPw", paramMap);
		return 1;
	}

}
