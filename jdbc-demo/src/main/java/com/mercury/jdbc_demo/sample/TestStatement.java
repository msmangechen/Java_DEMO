package com.mercury.jdbc_demo.sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.jdbc_demo.util.JdbcUtil;

public class TestStatement {

	public static void main(String[] args) {
		try (
			Connection conn = JdbcUtil.getConnection();
		) {
			
			// 其中一个不行，所有指令都不执行，那么使用ROLLBACK
			// transaction: a group of sql statements which can be
			// rolled back upon exception or committed upon success
			
			conn.setAutoCommit(false); // 我们不希望JDBC create或commit，所有的行为会被手动执行
			
			try {
				Sample s1 = new Sample("alex", 21);
				String sql1 = "INSERT INTO sample VALUES ('" + s1.getName() + "'," + s1.getAge() + ")";
				Statement st1 = conn.createStatement();
				st1.executeQuery(sql1);
				
//				Sample s2 = new Sample("bob", 21);
//				String sql2 = "INSERT INTO sample VALUES ('" + s2.getName() + "'," + s2.getAge() + ")";
//				Statement st2 = conn.createStatement();
//				st2.executeQuery(sql2);
				
				// ResultSet: get data from DB
				String sql3 = "SELECT * FROM sample";
				Statement st3 = conn.createStatement();
				ResultSet rs = st3.executeQuery(sql3);
				// cursor
				while (rs.next()) {
					System.out.println(rs.getString("name") + ": " + rs.getInt("age"));
				}
				
				conn.commit(); // 能到这行一定前面的没问题
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
