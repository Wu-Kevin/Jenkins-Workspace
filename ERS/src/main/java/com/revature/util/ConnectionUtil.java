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
		InputStream in = null;

		try {
			Properties props = new Properties();
			in = new FileInputStream("C:/Workspace/ERS/src/main/resources/connection.properties");
			props.load(in);

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String endpoint = props.getProperty("jdbc:oracle:thin:@kwudb.cpmpgeabndob.us-east-1.rds.amazonaws.com:1521:ORCL");
			String username = props.getProperty("kevin");
			String password = props.getProperty("52790Zsnxu");

			return DriverManager.getConnection(endpoint, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}