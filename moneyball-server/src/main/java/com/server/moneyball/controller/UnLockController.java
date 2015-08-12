package com.server.moneyball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.unlock.UnlockReq;
import com.server.moneyball.unlock.UnlockService;

@Controller
public class UnLockController {

	private UnlockService unlockService;

	// https://localhost:8443/moneyball-server/unlock?userNum=97&matchNum=7&unlockNum=3
	// https://166.104.142.94:61000/moneyball-server/unlock?userNum=97&matchNum=7&unlockNum=3
	@RequestMapping("/unlock")
	@ResponseBody
	public OperationResult doUnlock(UnlockReq UnlockReq) {
		try {
			int moneyball = unlockService.unlock(UnlockReq);
			return new OperationResult(true, moneyball);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}

	}

	public void setUnlockService(UnlockService unlockService) {
		this.unlockService = unlockService;
	}

}
