package com.server.moneyball.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.server.moneyball.unlock.UnlockDao;
import com.server.moneyball.unlock.UnlockReq;
import com.server.moneyball.unlock.UnlockVO;
import com.server.moneyball.user.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class UnlockDaoTest {
	@Autowired
	private UnlockDao unlockDao;

	@Test
	public void test() {
		UnlockReq unlockReq = new UnlockReq();
		unlockReq.setUserNum(98);
		unlockReq.setMatchNum(9);
		unlockReq.setUnlockNum(3);
		
		UnlockVO unlockvo = unlockDao.selectUserMoney(unlockReq);
		System.out.println(unlockvo.getScore());
		

		//unlockDao.subtractMoneyBall(98, 4700);
		//unlockDao.unlockTB(unlockReq);
	}

}
