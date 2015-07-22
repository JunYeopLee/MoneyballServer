package com.server.moneyball.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.user.UserService;
import com.server.moneyball.user.UserSignUpReq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml","classpath:/spring-service.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Test
	public void test(){
		UserSignUpReq userSignInReq = new UserSignUpReq(); 
		userSignInReq.setId("J1");
		userSignInReq.setPw("1234");
		userSignInReq.setKindOfSNS(0);
		//userService.insertUser(userSignInReq);
		userService.authenticate(userSignInReq.getId(), userSignInReq.getPw(),userSignInReq.getKindOfSNS());
		
	}
}
