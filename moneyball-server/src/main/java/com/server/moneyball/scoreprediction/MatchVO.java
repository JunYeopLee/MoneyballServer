package com.server.moneyball.scoreprediction;

import java.util.Date;

public class MatchVO {
	int matchId;
	String today;
	String stadiumName;
	String stadiumTime;
	String team1Name;
	String team2Name;
	String predictScore1;
	String predictScore2;
	String predictScore3;
	String predictScore4;
	String predictScore5;
	String predictPercent1;
	String predictPercent2;
	String predictPercent3;
	String predictPercent4;
	String predictPercent5;
	String rateTeam1;
	String rateTeam2;

	public MatchVO() {
		super();
	}

	public MatchVO(int matchId, String today, String stadiumName,
			String stadiumTime, String team1Name, String team2Name,
			String predictScore1, String predictScore2, String predictScore3,
			String predictScore4, String predictScore5, String predictPercent1,
			String predictPercent2, String predictPercent3,
			String predictPercent4, String predictPercent5, String rateTeam1,
			String rateTeam2) {
		super();
		this.matchId = matchId;
		this.today = today;
		this.stadiumName = stadiumName;
		this.stadiumTime = stadiumTime;
		this.team1Name = team1Name;
		this.team2Name = team2Name;
		this.predictScore1 = predictScore1;
		this.predictScore2 = predictScore2;
		this.predictScore3 = predictScore3;
		this.predictScore4 = predictScore4;
		this.predictScore5 = predictScore5;
		this.predictPercent1 = predictPercent1;
		this.predictPercent2 = predictPercent2;
		this.predictPercent3 = predictPercent3;
		this.predictPercent4 = predictPercent4;
		this.predictPercent5 = predictPercent5;
		this.rateTeam1 = rateTeam1;
		this.rateTeam2 = rateTeam2;
	}

	public String getRateTeam1() {
		return rateTeam1;
	}

	public void setRateTeam1(String rateTeam1) {
		this.rateTeam1 = rateTeam1;
	}

	public String getRateTeam2() {
		return rateTeam2;
	}

	public void setRateTeam2(String rateTeam2) {
		this.rateTeam2 = rateTeam2;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumTime() {
		return stadiumTime;
	}

	public void setStadiumTime(String stadiumTime) {
		this.stadiumTime = stadiumTime;
	}

	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public String getPredictScore1() {
		return predictScore1;
	}

	public void setPredictScore1(String predictScore1) {
		this.predictScore1 = predictScore1;
	}

	public String getPredictScore2() {
		return predictScore2;
	}

	public void setPredictScore2(String predictScore2) {
		this.predictScore2 = predictScore2;
	}

	public String getPredictScore3() {
		return predictScore3;
	}

	public void setPredictScore3(String predictScore3) {
		this.predictScore3 = predictScore3;
	}

	public String getPredictScore4() {
		return predictScore4;
	}

	public void setPredictScore4(String predictScore4) {
		this.predictScore4 = predictScore4;
	}

	public String getPredictScore5() {
		return predictScore5;
	}

	public void setPredictScore5(String predictScore5) {
		this.predictScore5 = predictScore5;
	}

	public String getPredictPercent1() {
		return predictPercent1;
	}

	public void setPredictPercent1(String predictPercent1) {
		this.predictPercent1 = predictPercent1;
	}

	public String getPredictPercent2() {
		return predictPercent2;
	}

	public void setPredictPercent2(String predictPercent2) {
		this.predictPercent2 = predictPercent2;
	}

	public String getPredictPercent3() {
		return predictPercent3;
	}

	public void setPredictPercent3(String predictPercent3) {
		this.predictPercent3 = predictPercent3;
	}

	public String getPredictPercent4() {
		return predictPercent4;
	}

	public void setPredictPercent4(String predictPercent4) {
		this.predictPercent4 = predictPercent4;
	}

	public String getPredictPercent5() {
		return predictPercent5;
	}

	public void setPredictPercent5(String predictPercent5) {
		this.predictPercent5 = predictPercent5;
	}

}
