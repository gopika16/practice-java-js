package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.TaxInfo;

public class TaxInfoDAO {
	private final String SEPERATOR = " ";

	public void retrive() {
		List<TaxInfo> taxList = null;
		try {
			taxList = getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (TaxInfo iterator : taxList) {
			String record = getString(iterator);
			System.out.println(record);
		}
	}

	private String getString(TaxInfo taxInfo) {
		StringBuilder taxRecord = new StringBuilder();
		taxRecord.append(taxInfo.getId());
		taxRecord.append(SEPERATOR);
		taxRecord.append(taxInfo.getTaxPercentage());
		return taxRecord.toString();
	}

	private List<TaxInfo> getList() throws SQLException {
		List<TaxInfo> taxInfoList = new ArrayList<TaxInfo>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM tax");
		while (resultSet.next()) {
			TaxInfo tax = new TaxInfo();
			tax.setId(resultSet.getInt(1));
			tax.setTaxPercentage(resultSet.getInt(2));
			taxInfoList.add(tax);
		}
		return taxInfoList;
	}

	public TaxInfo getTaxObject(ResultSet resultSet) throws SQLException {
		Integer getId = resultSet.getInt(6);
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		String queryString = "SELECT * FROM tax WHERE tax.id = " + String.valueOf(getId);
		ResultSet taxResultSet = statement.executeQuery(queryString);
		taxResultSet.next();
		TaxInfo tax = new TaxInfo();
		tax.setId(taxResultSet.getInt(1));
		tax.setTaxPercentage(taxResultSet.getInt(2));
		return tax;
	}
}
