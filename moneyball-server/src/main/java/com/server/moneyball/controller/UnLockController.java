package com.server.moneyball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.unlock.UnlockReq;
import com.server.moneyball.unlock.UnlockService;

@Controller
public class UnLockController {
	// https://166.104.142.94:8443/moneyball-server/unlock?userNum=21&matchNum=1&unlockNum=3

	private UnlockService unlockService;

	@RequestMapping("/unlock")
	@ResponseBody
	public OperationResult doUnlock(UnlockReq UnlockReq) {
		try {
			unlockService.unlock(UnlockReq);
			return new OperationResult(true);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}

	}

	public void setUnlockService(UnlockService unlockService) {
		this.unlockService = unlockService;
	}

}
