package com.server.moneyball.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-dao.xml",
		"classpath:/spring-ibatis.xml", "classpath:/spring-datasource.xml",
		"classpath:/spring-properties.xml", "classpath:/spring-tx.xml" })
public class dbconnectTest {
	@Autowired
	private DataSource dataSource;

	@Test
	public void dbconnecttest() throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmts = null;
		ResultSet rs = null;

		pstmts = conn.prepareStatement("select * from moneyball.USER_TB");
		rs = pstmts.executeQuery();
		rs.next();
		for(int i=1;i<7;i++){
			System.out.println(rs.getString(i));
		}
		rs.close();
		pstmts.close();
		conn.close();

	}

}
