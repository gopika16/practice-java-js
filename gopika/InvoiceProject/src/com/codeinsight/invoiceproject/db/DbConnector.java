package com.codeinsight.invoiceproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private final String URL = "jdbc:mysql://localhost:3306/invoicedatabase?useSSL=false";
	private final String USER_NAME = "root";
	private final String PASSWORD = "db2023Feb@";
	private DbConnector() {
	}
	static Connection connection = null;

	public static Connection getConnection() {
		DbConnector dbConnector = new DbConnector();
		if (connection == null) {
			synchronized (Connection.class) {
				System.out.println("--SYNCHRONIZED--");
				if (connection == null) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						connection = DriverManager.getConnection(dbConnector.URL,dbConnector.USER_NAME ,dbConnector.PASSWORD );
						System.out.println("--CONNECTION ESTABLISHED--");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("--DISCONNECTED--");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
