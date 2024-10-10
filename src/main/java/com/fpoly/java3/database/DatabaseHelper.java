package com.fpoly.java3.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

	public static Connection connectDatabase() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String urlString = "jdbc:sqlserver://localhost:1433;database=java3_demo;encrypt=false;";
			String username = "sa";
			String password = "123456A@";
			Connection connection = DriverManager.getConnection(urlString, username, password);

			return connection;
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

}
