package com.server.moneyball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.user.UserLoginDao;
import com.server.moneyball.user.UserVO;
import com.server.moneyball.user.UserVOList;

@Controller
public class UserLoginController {

	private UserLoginDao userLoginDao;
	
	
	// http://localhost:8080/moneyball/user/login?id=J&pw=1&kindOfSNS=1
	//http://166.104.142.94/moneyball-server/user/login?id=J&pw=1&kindOfSNS=1
	@RequestMapping("/user/login")
	public @ResponseBody OperationResult doLoginJSON(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("kindOfSNS") int kindOfSNS) {
		try{
		UserVOList userVOList = userLoginDao.selectUser(id, pw, kindOfSNS);
		return new OperationResult(true, userVOList);
		}catch(Exception e){
			return new OperationResult(false, "errorCode","id나 pw가 틀림");
		}
	}


	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}
	
	

}
