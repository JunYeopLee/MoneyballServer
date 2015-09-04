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

	// https://166.104.142.94:61000/moneyball-server/user/login?id=J&pw=3d59f7548e1af2151b64135003ce63c0a484c26b9b8b166a7b1c1805ec34b00a&kindOfSNS=1
	// https://localhost:8443/moneyball-server/user/login?id=mip55i14J&pw=3d59f7548e1af2151b64135003ce63c0a484c26b9b8b166a7b1c1805ec34b00a&kindOfSNS=1
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

	// https://166.104.142.94:61000/moneyball-server/user/signUp?id=1122&pw=434332242&kindOfSNS=0
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

	// https://localhost:8443/moneyball-server/user/chkIdDupl?id=juhee22kim
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
