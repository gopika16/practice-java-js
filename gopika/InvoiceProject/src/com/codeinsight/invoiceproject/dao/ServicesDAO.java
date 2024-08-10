package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.Services;

public class ServicesDAO {
	private final String SEPERATOR = " ";

	public void retrive() {
		List<Services> servicesList = null;
		try {
			servicesList = getList();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Services iterator : servicesList) {
			String record = getString(iterator);
			System.out.println(record);
		}
	}

	private List<Services> getList() throws SQLException {
		List<Services> servicesList = new ArrayList<Services>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
		while (resultSet.next()) {
			Services services = new Services();
			services.setId(resultSet.getInt(1));
			services.setName(resultSet.getString(2));
			services.setHourlyRate(resultSet.getInt(3));
			servicesList.add(services);
		}
		return servicesList;
	}

	private String getString(Services service) {
		StringBuilder serviceRecord = new StringBuilder();
		serviceRecord.append(service.getId());
		serviceRecord.append(SEPERATOR);
		serviceRecord.append(service.getName());
		serviceRecord.append(SEPERATOR);
		serviceRecord.append(service.getHourlyRate());
		return serviceRecord.toString();
	}
}
