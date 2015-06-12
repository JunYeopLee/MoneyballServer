package com.server.moneyball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.user.UserVO;

@Controller
public class UserLoginController {
	private UserVO userVo;

	// http://localhost:8080/moneyball/user/login?id=10&pwd=3&kindOfSNS
	@RequestMapping("/user/login")
	public @ResponseBody OperationResult doLoginJSON(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			@RequestParam("kindOfSNS") int kindOfSNS) {
		//userVo.setId(id);
		//userVo.setPw(pwd);
		//userVo.setKindOfSNS(kindOfSNS);
		//return userVo;
		
		return new OperationResult(true);
	}

	public void setUserVo(UserVO userVo) {
		this.userVo = userVo;
	}

}
