package com.mercury.jdbc_demo.sample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.mercury.jdbc_demo.util.JdbcUtil;

public class TestCallableStatement {

	public static void main(String[] args) {
		try (
			Connection conn = JdbcUtil.getConnection();
		) {
//			Sample s = new Sample("kate", 99);
//			String sql = "{call saveuser(?, ?, ?, ?)}"; // 前两个是IN，后两个是OUT
//			CallableStatement cs = conn.prepareCall(sql);
//			cs.setString(1, s.getName());
//			cs.setInt(2, s.getAge());
//			cs.registerOutParameter(3, Types.INTEGER);
//			cs.registerOutParameter(4, Types.INTEGER);
//			cs.execute();
//			System.out.println("Result: " + cs.getInt(3));
//			System.out.println("Data: " + cs.getInt(4));
			
			// PreparedStatement能call SP不能call function
			// CallableStatement可以call stored procedure和function
			
			// function
			String sql = "{? = call hello(?)}"; // ?: ouput ?: input
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(2, 1);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.executeQuery();
			System.out.println(cs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
