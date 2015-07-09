package com.server.moneyball.user;

import org.apache.shiro.authc.AuthenticationException;


public class UserServiceImpl implements UserService {

	UserLoginDao userLoginDao;

	@Override
	public UserVO authenticate(String id, String pw, int kindOfSNS) {
		
		UserVO userVO;
		
		if(kindOfSNS==0){
			userVO = noneAuthCheck(id, pw, kindOfSNS);
		}else{
			userVO = snsAuthCheck(id,pw,kindOfSNS);
		}
		return userVO;
	}
	
	public UserVO noneAuthCheck(String id, String pw, int kindOfSNS) {
		UserVO foundUser = findUser(id, kindOfSNS);
		checkNull(foundUser);
		checkPasswordEquals(foundUser,pw);
		return null;
	}
	public UserVO findUser(String id, int kindOfSNS) {
		UserVO founduser = userLoginDao.findUser(id, kindOfSNS);
		return founduser;
	}

	public void checkNull(UserVO foundUser) {
		if (foundUser == null) {
			throw new AuthenticationException("invalid userid");
		}
	}

	public void checkPasswordEquals(UserVO foundUser, String pw) {
		if (!foundUser.isPasswordEquals(pw)) {
			throw new AuthenticationException("invalid password");
		}		
	}

	public UserVO snsAuthCheck(String id, String pw, int kindOfSNS) {
		/*UserVO foundUser = findUser(id);
		if (foundUser == null) {	// id가 존재 하지 않을 경우
			if (kindOfSNS != 0) {	// SNS 일 경우
				insertUserSNS(id, pw, kindOfSNS);	// SNS 최초 로그인 시 회원가입
				getUserVoList(id, pw, kindOfSNS);
			}
		}*/
		UserVO userVO = userLoginDao.selectUserInfo(id, pw, kindOfSNS);
		/*if (userVO.getList().isEmpty() && kindOfSNS != 0) {
			userVO = insertUserSNS("PwIsSNS", pw, kindOfSNS);
		}*/
		return userVO;
	}

	public UserVO insertUserSNS(String id, String pw, int kindOfSNS) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(UserSignInReq userSignInReq) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

}
