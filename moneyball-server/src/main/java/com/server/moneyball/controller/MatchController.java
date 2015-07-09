package com.server.moneyball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.moneyball.scoreprediction.MatchVOList;
import com.server.moneyball.scoreprediction.SelectMatchListDao;

@Controller
public class MatchController {

	private SelectMatchListDao selectMatchListDao;
	
	// http://localhost:8080/moneyball/scorepredict/matchlist?userNum=1&today=20150623
	@RequestMapping("scorepredict/matchlist")
	public @ResponseBody OperationResult doMatchListJSON(@RequestParam("userNum") int userNum, @RequestParam("today") String today){
		try{
			MatchVOList matchVOList = selectMatchListDao.selectMatchList(userNum, today);
			return new OperationResult(true, matchVOList);
		}catch(Exception e){
			return new OperationResult(false, "errorCode","에러남요");
		}
	}
	

	public void setSelectMatchListDao(SelectMatchListDao selectMatchListDao) {
		this.selectMatchListDao = selectMatchListDao;
	}
	
	
}
