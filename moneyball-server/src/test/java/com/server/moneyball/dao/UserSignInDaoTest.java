package com.server.moneyball.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.user.UserSignUpDao;
import com.server.moneyball.user.UserSignUpReq;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class UserSignInDaoTest{
	@Autowired
	private UserSignUpDao userSignInDao;
	

	@Test
	public void test() {
		UserSignUpReq userSignInReq = new UserSignUpReq();
		userSignInReq.setId("dododododo");
		userSignInReq.setPw("1232323234");
		userSignInReq.setKindOfSNS(1);
		userSignInDao.insertUser(userSignInReq);
		userSignInDao.procedure_insertUlockTB(userSignInReq);
	}

}
