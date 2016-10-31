package com.server.moneyball.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.security.MessageDigest;

import com.server.moneyball.user.UserLoginDao;
import com.server.moneyball.user.UserService;
import com.server.moneyball.user.UserVO;
import com.server.moneyball.user.UserVOList;
import com.server.moneyball.user.UserSignUpReq;

@Controller
public class UserController {

	private UserService userService;

	@RequestMapping("/user/login")
	public @ResponseBody OperationResult doLoginJSON(
			@RequestParam("id") String id, @RequestParam("pw") String pw,
			@RequestParam("kindOfSNS") int kindOfSNS) {
		try {
			String encryptPw = encrypt(pw);
			UserVO userVO = userService.authenticate(id, encryptPw, kindOfSNS);
			return new OperationResult(true, userVO);
		} catch (AuthenticationException ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}

	@RequestMapping("/user/signUp")
	@ResponseBody
	public OperationResult doSignUp(UserSignUpReq userSignUpReq) {
		try {
			String encryptPw = encrypt(userSignUpReq.getPw());
			userSignUpReq.setPw(encryptPw);
			userService.signUpUser(userSignUpReq);
			return new OperationResult(true);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}
	}

	@RequestMapping("/user/chkIdDupl")
	@ResponseBody
	public OperationResult chkIdDupl(String id) {
		try {
			boolean result = userService.duplicationId(id);
			return new OperationResult(result, "해당 ID로 가입 여부: " + result + " 중복확인 완료");
		} catch (Exception ex) {
			return new OperationResult(false, "에러로 인한 중복확인 실패", ex.getMessage());
		}
	}

	private String encrypt(String pw) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
