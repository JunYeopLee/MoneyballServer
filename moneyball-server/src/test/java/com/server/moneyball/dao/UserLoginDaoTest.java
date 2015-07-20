package com.server.moneyball.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.user.UserLoginDao;
import com.server.moneyball.user.UserVO;
import com.server.moneyball.user.UserVOList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class UserLoginDaoTest {
	@Autowired
	private UserLoginDao userLoginDao;

	@Test
	public void userlogindaoTest() {

		UserVO v = userLoginDao.findOne("J", 1);
		//userLoginDao.selectUserInfo("J", "1", 1);

		//UserVO v = userLoginDao.findUser("J", 0);
		//assertFalse(v.getList().isEmpty());
		//assertFalse(v.getId().isEmpty());
	}

}
