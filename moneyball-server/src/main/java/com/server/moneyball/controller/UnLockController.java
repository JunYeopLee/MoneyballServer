package com.server.moneyball.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.unlock.UnlockReq;
import com.server.moneyball.unlock.UnlockService;
import com.server.moneyball.unlock.UnlockVO;

@Controller
public class UnLockController {

	private UnlockService unlockService;

	@RequestMapping("/unlock")
	@ResponseBody
	public OperationResult doUnlock(UnlockReq UnlockReq) {
		try {
			UnlockVO unlockVO =  unlockService.unlock(UnlockReq);
			ArrayList<String> result = new ArrayList<>();
			result.add(String.valueOf(unlockVO.getUserMoneyResult()));
			result.add(unlockVO.getScore());
			return new OperationResult(true, result);
		} catch (Exception ex) {
			return new OperationResult(false, "errorCode", ex.getMessage());
		}

	}

	public void setUnlockService(UnlockService unlockService) {
		this.unlockService = unlockService;
	}

}
