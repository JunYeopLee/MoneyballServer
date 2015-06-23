package com.server.moneyball.controller;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.user.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring-controller.xml", "classpath:/spring-mvc.xml"})
public class UserLoginControllerTest {
	
	private UserController controller = new UserController();
	
	@Autowired
	private UserVO user;
	
	public void setUp(){
	}

}
