package com.server.moneyball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.betting.BettingService;
import com.server.moneyball.betting.UserBettingReq;

@Controller
public class BettingController {

	BettingService bettingService;

	// https://166.104.142.94:61000/moneyball-server/betting?userNum=#userNum#&betStates=#betStates#&betMoney=#betMoney#
	// https://localhost:8443/moneyball-server/betting?userNum=97&betStates=1001100010&betMoney=500
	@RequestMapping("/betting")
	@ResponseBody
	public OperationResult doSaveUserBetting(UserBettingReq userBettingReq) {
		try {
			bettingService.saveUserBetting(userBettingReq);
			return new OperationResult(true,"success");
			} catch (Exception ex) {
			return new OperationResult(false,"errorCode", ex.getMessage());
		}
	}

	public void setBettingService(BettingService bettingService) {
		this.bettingService = bettingService;
	}
}
