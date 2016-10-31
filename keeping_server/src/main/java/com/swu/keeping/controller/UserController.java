package com.swu.keeping.controller;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swu.keeping.user.DonateReq;
import com.swu.keeping.user.RegistBloodReq;
import com.swu.keeping.user.SelectInfoDao;
import com.swu.keeping.user.UserBloodVO;
import com.swu.keeping.user.UserDetailVO;
import com.swu.keeping.user.UserService;
import com.swu.keeping.user.UserSignUpReq;
import com.swu.keeping.user.UserVO;

@Controller
public class UserController 
{
	private UserService userService;
	private SelectInfoDao selectInfoDao;
	

	@RequestMapping("/user/login")
	public @ResponseBody OperationResult doLoginJSON(
			@RequestParam("id") String id, @RequestParam("pw") String pw) {
		try {
			UserVO userVO = userService.authenticate(id, pw);
			return new OperationResult(true, userVO);
		} catch (AuthenticationException ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}

	@RequestMapping("/user/signUp")
	@ResponseBody
	public OperationResult doSignUp(UserSignUpReq userSignUpReq) {
		try {
			userService.signUpUser(userSignUpReq);
			return new OperationResult(true);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}

	@RequestMapping("/user/viewUserInfo")
	public @ResponseBody OperationResult viewUserInfo(@RequestParam("userId") String id){
		try{
			UserDetailVO userDatailInfo = selectInfoDao.selectUserDatailInfo(id);
			return new OperationResult(true, userDatailInfo);
		}catch(Exception e){
			return new OperationResult(false, "errorCode","에러남요");
		}
	}
	
	@RequestMapping("/user/viewBloodInfo")
	public @ResponseBody OperationResult viewBloodInfo(@RequestParam("userId") String id){
		try{
			List<UserBloodVO> userBloodInfo = selectInfoDao.selectUserBloodInfo(id);
			return new OperationResult(true, userBloodInfo);
		}catch(Exception e){
			return new OperationResult(false, "errorCode","에러남요");
		}
	}
	
	@RequestMapping("/user/donateBlood")
	@ResponseBody
	public OperationResult donateBlood(DonateReq donateReq) {
		try {
			userService.donateBlood(donateReq);
			return new OperationResult(true);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}
	
	@RequestMapping("/user/useBlood")
	public @ResponseBody OperationResult useBlood(
			@RequestParam("bloodId") String bloodId, @RequestParam("userId") String userID) {
		
		try {
			userService.useBlood(bloodId,userID);
			return new OperationResult(true);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}
	
	@RequestMapping("/user/registBlood")
	@ResponseBody
	public OperationResult registBlood(RegistBloodReq registBloodReq) {
		try {
			userService.registBlood(registBloodReq);
			return new OperationResult(true);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}
	
	@RequestMapping("/reset")
	@ResponseBody
	public OperationResult reset(){
		try{
			selectInfoDao.reset();
			return new OperationResult(true);
		}catch(Exception e){
			return new OperationResult(false, "errorCode","에러남요");
		}
		
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSelectInfoDao(SelectInfoDao selectInfoDao) {
		this.selectInfoDao = selectInfoDao;
	}
	
	
	
	

}
