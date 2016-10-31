package com.swu.keeping.dao;

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

import com.swu.keeping.user.DonateBloodDao;
import com.swu.keeping.user.DonateReq;
import com.swu.keeping.user.RegistBloodDao;
import com.swu.keeping.user.RegistBloodReq;
import com.swu.keeping.user.SelectInfoDao;
import com.swu.keeping.user.UseBloodDao;
import com.swu.keeping.user.UserBloodVO;
import com.swu.keeping.user.UserLoginDao;
import  com.swu.keeping.user.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class DaoTest {
/*	@Autowired
	private UserLoginDao userLoginDao;*/
	@Autowired
	private SelectInfoDao selectInfoDao;
	//private DonateBloodDao donateBloodDao;
	//private RegistBloodDao registBloodDao;

	//private UseBloodDao useBloodDao;
	
	@Test
	public void userlogindaoTest() {

		//UserVO v = userLoginDao.findOne("J", 1);
		//userLoginDao.selectUserInfo("J", "1", 1);

		//UserVO v = userLoginDao.findUser("J", 0);
		//assertFalse(v.getList().isEmpty());
		//assertFalse(v.getId().isEmpty());
/*		
		UserVO v = new UserVO();
		v.setId("dododododo");
		v.setPw("1232323234");*/
		
		//selectInfoDao.selectUserDatailInfo("kjh1203");
		//UserBloodVO u = selectInfoDao.
		//System.out.println(u.getBIRTH_DATE());
		
		
/*		DonateReq donateReq = new DonateReq();;
		donateReq.setBloodId("1");
		donateReq.setSendUserId("mipi13");
		donateReq.setGetUserId("dododododo");
		
		donateBloodDao.updateDonate(donateReq);*/
		/*
		RegistBloodReq r = new RegistBloodReq();
		r.setId("123");
		r.setBirthDate("2014");
		r.setBloodAmount("전혈");
		r.setBloodDate("2015.11.01");
		r.setBloodLoc("인천");
		r.setBloodSex("여");
		r.setBloodType("A");
		r.setHumanName("준여비");
		r.setNextBloodDate("2015.11.12");
		r.setSenderId("mipi13");
		r.setUserId("mmm11");
		registBloodDao.registBlood(r);*/
		
		//useBloodDao.useBlood("12", "mipi13");
		selectInfoDao.reset();

	}

}
