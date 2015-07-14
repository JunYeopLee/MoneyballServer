package com.server.moneyball.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.user.UserLoginDao;
import com.server.moneyball.user.UserService;
import com.server.moneyball.user.UserVO;
import com.server.moneyball.user.UserVOList;
import com.server.moneyball.user.UserSignInReq;

@Controller
public class UserController {

	private UserService userService;

	// http://localhost:8080/moneyball-server/user/login?id=J&pw=1&kindOfSNS=0
	// http://166.104.142.94:8443/moneyball-server/user/login?id=J&pw=1&kindOfSNS=0
	// https://localhost:8443/moneyball-server/user/login?id=J&pw=1&kindOfSNS=0
	@RequestMapping("/user/login")
	public @ResponseBody OperationResult doLoginJSON(
			@RequestParam("id") String id, @RequestParam("pw") String pw,
			@RequestParam("kindOfSNS") int kindOfSNS) {
		try {
			
			UserVO userVO = userService.authenticate(id, pw, kindOfSNS);
			return new OperationResult(true, userVO);
		} catch (AuthenticationException ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}

	@RequestMapping("/user/signIn")
	@ResponseBody
	public OperationResult doSignIn(UserSignInReq userSignInreq) {
		try {

			return new OperationResult(true);
		} catch (Exception e) {
			return new OperationResult(false, "-1", "실패");
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
