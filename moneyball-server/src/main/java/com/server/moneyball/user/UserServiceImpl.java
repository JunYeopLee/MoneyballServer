package com.server.moneyball.user;

import java.sql.SQLException;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

	UserLoginDao userLoginDao;
	UserSignUpDao userSignUpDao;
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
	public void signUpUser(UserSignUpReq userSignUpReq) {
		try {
			userSignUpDao.insertUser(userSignUpReq);
			userSignUpDao.procedure_insertUlockTB(userSignUpReq);
		} catch (DuplicateKeyException sqlExc) {
			throw new DuplicateKeyException("이미 사용중인 ID입니다.");
		}
	}

	// 중복확인
	@Override
	public boolean duplicationId(String id) {
		UserVO user = userSignUpDao.findId(id);
		boolean check = true;
		if (user != null) {
			check = false;
		}
		return check;
	}

	// 비밀번호 수정
	@Transactional
	@Override
	public void modifyPassword(String id, int kindOfSNS, int userNum,
			String newPassword, String oldPassword) {
		if (!id.equals("") && !id.equals(null)) {
			UserVO user = findUser(id, kindOfSNS);
			user.changePassword(newPassword, oldPassword);
			modifyPassword(userNum, user.getPw());
		}
	}

	private void modifyPassword(int userNum, String pw) {
		try {
			userModifyDao.modyfyUserPw(userNum, pw);
		} catch (Exception e) {
			throw new AuthenticationException("modify fail");
		}
	}

	public UserVO noneAuthCheck(String id, String encryptPw, int kindOfSNS) {
		UserVO foundUser = findUser(id, kindOfSNS);
		checkNull(foundUser);
		checkPasswordEquals(foundUser, encryptPw);
		//foundUser.setPw(""); // 보낼때 password 안보이게 하기
		//출석 체크 시 머니볼 지급
		getMoneyByAttendance(id, kindOfSNS);
		foundUser = findUser(id, kindOfSNS);
		foundUser.setPw(""); // 보낼때 password 안보이게 하기
		return foundUser;
	}

	public UserVO snsAuthCheck(String id, String encryptPw, int kindOfSNS) {
		UserVO foundUser = findUser(id, kindOfSNS);
		if (foundUser == null) { // id가 존재 하지 않을 경우
			UserSignUpReq userSignUpReq = new UserSignUpReq();
			userSignUpReq.setId(id);
			userSignUpReq.setPw(encryptPw);
			userSignUpReq.setKindOfSNS(kindOfSNS);
			return snsSingUp(userSignUpReq, foundUser);
		} else {
			//출석 체크 시 머니볼 지급
			getMoneyByAttendance(id, kindOfSNS);
			foundUser = findUser(id, kindOfSNS);
			foundUser.setPw("");
			return foundUser;
		}
	}

	private UserVO snsSingUp(UserSignUpReq userSignUpReq, UserVO foundUser) {
		signUpUser(userSignUpReq);
/*		foundUser = findUser(userSignUpReq.getId(),
				userSignUpReq.getKindOfSNS());*/
		//출석 체크 시 머니볼 지급
		getMoneyByAttendance(userSignUpReq.getId(),
				userSignUpReq.getKindOfSNS());
		foundUser = findUser(userSignUpReq.getId(),
				userSignUpReq.getKindOfSNS());
		foundUser.setPw(""); // 보낼때 password 안보이게 하기
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
	

	public void getMoneyByAttendance(String id, int kindOfSNS) {
		userLoginDao.updateMoneyByAttendance(id, kindOfSNS);
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	public void setUserSignUpDao(UserSignUpDao userSignUpDao) {
		this.userSignUpDao = userSignUpDao;
	}

	public void setUserModifyDao(UserModifyDao userModifyDao) {
		this.userModifyDao = userModifyDao;
	}

}
