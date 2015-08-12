package com.server.moneyball.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.betting.SaveUserBettingDao;
import com.server.moneyball.betting.UserBettingReq;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class SaveUserBettingDaoTest {
	@Autowired
	private SaveUserBettingDao saveUserBettingDao;

	@Test
	public void test() {
		UserBettingReq userBettingReq = new UserBettingReq();
		userBettingReq.setUserNum(96);
		userBettingReq.setBetStates("0101010101");
		userBettingReq.setBetMoney(1000);
		
		saveUserBettingDao.insertUserBetting(userBettingReq);
	}

}
