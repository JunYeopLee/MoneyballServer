package com.server.moneyball.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.scoreprediction.MatchVOList;
import com.server.moneyball.scoreprediction.SelectMatchListDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class SelectMatchListDaoTest {
	@Autowired
	SelectMatchListDao selectMatchListDao;
	
	@Test
	public void test(){
		MatchVOList matchList = selectMatchListDao.selectMatchList(1, "20150623");
		System.out.println(matchList.getMatchVOList().get(0).getMatchId());
		
	}

}
