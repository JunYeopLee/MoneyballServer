package com.server.moneyball.betting;

public class BettingServiceImpl implements BettingService {
	
	SaveUserBettingDao saveUserBettingDao;
	
	@Override
	public void saveUserBetting(UserBettingReq userBettingReq) {
		
		saveUserBettingDao.insertUserBetting(userBettingReq);

	}

	public void setSaveUserBettingDao(SaveUserBettingDao saveUserBettingDao) {
		this.saveUserBettingDao = saveUserBettingDao;
	}
	
	

}
