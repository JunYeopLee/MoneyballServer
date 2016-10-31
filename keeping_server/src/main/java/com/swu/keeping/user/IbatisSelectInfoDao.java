package com.swu.keeping.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class IbatisSelectInfoDao extends SqlMapClientDaoSupport implements
		SelectInfoDao {


	@SuppressWarnings("unchecked")
	@Override
	public UserDetailVO selectUserDatailInfo(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		 UserDetailVO userdetailVo = (UserDetailVO) getSqlMapClientTemplate().queryForObject(
				"UserDetailInfo.selectUserDatailInfo", paramMap);
		return userdetailVo;
	}

	@Override
	public List<UserBloodVO> selectUserBloodInfo(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		List<UserBloodVO> userbloodVo = (List<UserBloodVO>) getSqlMapClientTemplate().queryForList(
				"UserBloodInfo.selectUserBloodInfo", paramMap);
		return userbloodVo;
	}

	@Transactional
	@Override
	public void reset() {
		getSqlMapClientTemplate().delete("Reset.deleteUserTB");
		getSqlMapClientTemplate().delete("Reset.deleteBloodTB");
		getSqlMapClientTemplate().insert("Reset.insertUserTB");
		getSqlMapClientTemplate().insert("Reset.insertBloodTB");
	}

}
