package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.util.LogUtil;

public final class ConnectionUtil {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LogUtil.logger.warn("exception thrown adding oracle driver.", e);
		}
	}

	public static Connection getConnection() throws SQLException{

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");


			return DriverManager.getConnection("jdbc:oracle:thin:@kwudb.cpmpgeabndob.us-east-1.rds.amazonaws.com:1521:ORCL", "kevin", "52790Zsnxu");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		

		return null;
	
	} 
}
