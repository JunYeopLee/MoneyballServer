package com.swu.keeping.user;

import org.apache.shiro.authc.AuthenticationException;

public class UserServiceImpl implements UserService {

	UserLoginDao userLoginDao;
	UserSignUpDao userSignUpDao;
	DonateBloodDao donateBloodDao;
	UseBloodDao useBloodDao;
	RegistBloodDao registBloodDao;

	@Override
	public UserVO authenticate(String id, String pw) {
		UserVO userVO;
		userVO = authCheck(id, pw);
		return userVO;
	}

	@Override
	public void signUpUser(UserSignUpReq userSignUpReq) {
		userSignUpDao.insertUser(userSignUpReq);
	}

	@Override
	public void donateBlood(DonateReq donateReq) {
		donateBloodDao.updateDonate(donateReq);

	}

	@Override
	public void useBlood(String bloodId, String userID) {
		useBloodDao.useBlood(bloodId, userID);

	}

	@Override
	public void registBlood(RegistBloodReq registBloodReq) {
		registBloodDao.registBlood(registBloodReq);
	}

	private UserVO authCheck(String id, String pw) {
		UserVO foundUser = findUser(id, pw);
		checkNull(foundUser);
		checkPasswordEquals(foundUser, pw);
		foundUser = findUser(id, pw);
		return foundUser;
	}

	public UserVO findUser(String id, String pw) {
		UserVO founduser = userLoginDao.findOne(id, pw);
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

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	public void setUserSignUpDao(UserSignUpDao userSignUpDao) {
		this.userSignUpDao = userSignUpDao;
	}

	public void setDonateBloodDao(DonateBloodDao donateBloodDao) {
		this.donateBloodDao = donateBloodDao;
	}

	public void setUseBloodDao(UseBloodDao useBloodDao) {
		this.useBloodDao = useBloodDao;
	}

	public void setRegistBloodDao(RegistBloodDao registBloodDao) {
		this.registBloodDao = registBloodDao;
	}

}
