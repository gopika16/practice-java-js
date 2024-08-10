package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.CompanyInfo;

public class CompanyInfoDAO {
	private final String SEPERATOR = " ";

	public void retrive() {
		List<CompanyInfo> companyInfoList = null;
		try {
			companyInfoList = getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (CompanyInfo iterator : companyInfoList) {
			String record = getString(iterator);
			System.out.println(record);
		}

	}

	public List<CompanyInfo> getList() throws SQLException {
		List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM company");
		while (resultSet.next()) {
			CompanyInfo companyInfo = new CompanyInfo();
			companyInfo.setId(resultSet.getInt(1));
			companyInfo.setName(resultSet.getString(2));
			companyInfo.setAddress(resultSet.getString(3));
			companyInfo.setContactNumber(resultSet.getLong(4));
			companyInfo.setEmailId(resultSet.getString(5));
			companyInfoList.add(companyInfo);
		}
		return companyInfoList;
	}

	private String getString(CompanyInfo companyInfo) {
		StringBuilder companyRecord = new StringBuilder();
		companyRecord.append(companyInfo.getId());
		companyRecord.append(SEPERATOR);
		companyRecord.append(companyInfo.getName());
		companyRecord.append(SEPERATOR);
		companyRecord.append(companyInfo.getAddress());
		companyRecord.append(SEPERATOR);
		companyRecord.append(companyInfo.getContactNumber());
		companyRecord.append(SEPERATOR);
		companyRecord.append(companyInfo.getEmailId());
		return companyRecord.toString();
	}
}
