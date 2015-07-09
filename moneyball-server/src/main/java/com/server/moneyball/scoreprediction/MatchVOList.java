package com.server.moneyball.scoreprediction;

import java.util.List;

public class MatchVOList {
	private List<MatchVO> matchVOList;

	public MatchVOList(List<MatchVO> matchVOList) {
		super();
		this.matchVOList = matchVOList;
	}

	public MatchVOList() {
		super();
	}

	public List<MatchVO> getMatchVOList() {
		return matchVOList;
	}

}
