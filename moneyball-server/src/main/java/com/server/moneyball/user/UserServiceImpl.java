package com.server.moneyball.user;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;
public class UserServiceImpl implements UserService {

	UserLoginDao userLoginDao;
	UserSignInDao userSignInDao;
	UserModifyDao userModifyDao;

	// 로그인
	@Override
	public UserVO authenticate(String id, String encryptPw, int kindOfSNS) {

		UserVO userVO;

		if (kindOfSNS == 0) {
			userVO = noneAuthCheck(id, encryptPw, kindOfSNS);
		} else {
			userVO = snsAuthCheck(id, encryptPw, kindOfSNS);
		}
		return userVO;
	}
	
	// 가입
	@Override
	public void signInUser(UserSignInReq userSignInReq) {
		try {
			userSignInDao.insertUser(userSignInReq);
		} catch (Exception e) {
			throw new AuthenticationException("SNS SignIn fail");
		}
	}
	
	// 중복확인
	@Override
	public boolean duplicationId(String id) {
		UserVO user = userSignInDao.findId(id);
		boolean check = true;
		if(user !=null){
			check = false;
		}
		return check;
	}
	

	// 비밀번호 수정
	@Transactional
	@Override
	public void modifyPassword(String id, int kindOfSNS, int userNum, String newPassword,String oldPassword){
		if(!id.equals("") &&!id.equals(null)){
			UserVO user = findUser(id, kindOfSNS);
			user.changePassword(newPassword, oldPassword);
			modyfyPassword(userNum, user.getPw());
		}
	}

	private void modyfyPassword(int userNum, String pw) {
		try {
			userModifyDao.modyfyUserPw(userNum, pw);
		} catch (Exception e) {
			throw new AuthenticationException("SNS SignIn fail");
		}		
	}

	public UserVO noneAuthCheck(String id, String encryptPw, int kindOfSNS) {
		UserVO foundUser = findUser(id, kindOfSNS);
		checkNull(foundUser);
		checkPasswordEquals(foundUser, encryptPw);
		foundUser.setPw("");	// 보낼때 password 안보이게 하기
		return foundUser;
	}

	public UserVO snsAuthCheck(String id, String encryptPw, int kindOfSNS) {
		UserVO foundUser = findUser(id, kindOfSNS);
		if (foundUser == null) { // id가 존재 하지 않을 경우
			UserSignInReq userSignInReq = new UserSignInReq();
			userSignInReq.setId(id);
			userSignInReq.setPw(encryptPw);
			userSignInReq.setKindOfSNS(kindOfSNS);
			return snsSingIn(userSignInReq, foundUser);
		} else {
			return foundUser;
		}
	}
	
	private UserVO snsSingIn(UserSignInReq userSignInReq, UserVO foundUser) {
		signInUser(userSignInReq);
		foundUser = findUser(userSignInReq.getId(),	userSignInReq.getKindOfSNS());
		foundUser.setPw("");	// 보낼때 password 안보이게 하기
		return foundUser;
	}

	public UserVO findUser(String id, int kindOfSNS) {
		UserVO founduser = userLoginDao.findOne(id, kindOfSNS);
		return founduser;
	}

	public void checkNull(UserVO foundUser) {
		if (foundUser == null) {
			throw new AuthenticationException("invalid userid");
		}
	}

	public void checkPasswordEquals(UserVO foundUser, String encryptPw) {
		if (!foundUser.isPasswordEquals(encryptPw)) {
			throw new AuthenticationException("invalid password");
		}
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	public void setUserSignInDao(UserSignInDao userSignInDao) {
		this.userSignInDao = userSignInDao;
	}
	
	public void setUserModifyDao(UserModifyDao userModifyDao) {
		this.userModifyDao = userModifyDao;
	}



}
