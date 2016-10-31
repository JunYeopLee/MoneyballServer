package com.swu.keeping.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swu.keeping.user.UserSignUpDao;
import com.swu.keeping.user.UserSignUpReq;

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
		userSignInReq.setId("mipi13");
		userSignInReq.setPw("1");
		userSignInReq.setBloodType("A");
		userSignInReq.setIdNo("891203-3");
		userSignInReq.setJob("대학원생");
		userSignInReq.setName("주히띠");
		
		userSignInDao.insertUser(userSignInReq);
	}

}
