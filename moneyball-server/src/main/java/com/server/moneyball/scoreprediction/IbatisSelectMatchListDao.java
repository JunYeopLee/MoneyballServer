package com.server.moneyball.scoreprediction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IbatisSelectMatchListDao extends SqlMapClientDaoSupport implements
		SelectMatchListDao {

	@SuppressWarnings("unchecked")
	@Override
	public MatchVOList selectMatchList(int userNum, String today) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userNum", userNum);
		paramMap.put("today", today);
		List<MatchVO> matchVO = getSqlMapClientTemplate().queryForList("MatchList.selectMatchList", paramMap);
		return new MatchVOList(matchVO);
	}


}
