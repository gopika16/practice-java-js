package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.Employee;

public class EmployeeDAO {
	private final String SEPERATOR = " ";

	public void retrive() {
		List<Employee> employeeList = null;
		try {
			employeeList = getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Employee iterator : employeeList) {
			String record = getString(iterator);
			System.out.println(record);

		}

	}

	public List<Employee> getList() throws SQLException {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setExtension(resultSet.getLong(3));
			employee.setDepartment(resultSet.getString(4));
			employeeList.add(employee);
		}
		return employeeList;
	}

	private String getString(Employee employee) {

		StringBuilder employeeRecord = new StringBuilder();
		employeeRecord.append(employee.getId());
		employeeRecord.append(SEPERATOR);
		employeeRecord.append(employee.getName());
		employeeRecord.append(SEPERATOR);
		employeeRecord.append(employee.getExtension());
		employeeRecord.append(SEPERATOR);
		employeeRecord.append(employee.getDepartment());
		return employeeRecord.toString();
	}

	public Employee getEmployeeObject(Integer id) throws SQLException {
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		String queryString = "SELECT * FROM employee WHERE employee.id = " + String.valueOf(id);
		ResultSet employeeResultSet = statement.executeQuery(queryString);
		employeeResultSet.next();
		Employee employee = new Employee();
		employee.setId(employeeResultSet.getInt(1));
		employee.setName(employeeResultSet.getString(2));
		employee.setExtension(employeeResultSet.getLong(3));
		employee.setDepartment(employeeResultSet.getString(4));
		return employee;
	}

}
