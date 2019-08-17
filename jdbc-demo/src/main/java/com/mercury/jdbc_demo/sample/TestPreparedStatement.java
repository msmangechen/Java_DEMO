package com.mercury.jdbc_demo.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mercury.jdbc_demo.util.JdbcUtil;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (
			Connection conn = JdbcUtil.getConnection();
		) {
			// 用Statement会带来：SQL Injection 问题
//			String name = "bob"; // hacker: "bob or 1=1", 所有用户显示
//			String sql1 = "SELECT * FROM sample WHERE name='" +  name + "'";
//			Statement st1 = conn.createStatement();
//			ResultSet rs1 = st1.executeQuery(sql1);
//			while (rs1.next()) {
//				System.out.println(rs1.getString("name") + ": " + rs1.getInt("age"));
//			}
			
			String name = "bob or 1=1";
			String sql1 = "SELECT * FROM sample WHERE name=?";
			PreparedStatement st1 = conn.prepareStatement(sql1); // 只会执行sql1，escape name
			st1.setString(1, name); // 1是parameter index, ?的数量
			ResultSet rs1 = st1.executeQuery(); // 不需要有sql1在里面
			while (rs1.next()) {
				System.out.println(rs1.getString("name") + ": " + rs1.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
