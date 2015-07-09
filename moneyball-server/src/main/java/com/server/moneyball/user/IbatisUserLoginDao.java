package com.server.moneyball.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.server.moneyball.user.UserLoginDao;

public class IbatisUserLoginDao extends SqlMapClientDaoSupport implements
		UserLoginDao {

	@SuppressWarnings("unchecked")
	@Override
	public UserVO selectUserInfo(String id, String pw, int kindOfSNS) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("pw", pw);
		paramMap.put("kindOfSNS", kindOfSNS);
		UserVO userVO = (UserVO)getSqlMapClientTemplate().queryForObject(
				"UserLogin.selectUserInfo", paramMap);
		return userVO;
	}

	@Override
	public UserVO findUser(String id, int kindOfSNS) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("kindOfSNS", kindOfSNS);
		UserVO userVO = (UserVO) getSqlMapClientTemplate().queryForObject("UserLogin.findUser", paramMap);
		return userVO;
		
	}

}
