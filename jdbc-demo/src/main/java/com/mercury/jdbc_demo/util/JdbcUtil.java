package com.mercury.jdbc_demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 4个参数需要记住
public class JdbcUtil {
	
	// before JDBC 4
	// 写在class有什么坏处？如果修改了其中的，需要compile整个class文件
	// 写在Tomcat conf context.xml添加4个参数，就不需要每次更改了再编译了
	private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // path to Database
	private static final String USERNAME="msi";
	private static final String PASSWORD="mercury";
	// 如果被黑，更改密码需要重新编译Java class
	
	// return connection from SQL
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// before JDBC 4, need manually load the driver class
			Class.forName(DRIVER_CLASS); //用于 load particular class
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
