package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.Terms;

public class TermsDAO {
	private final String SEPERATOR = " ";
	public void retrive() {
		List<Terms> termList = null;
		try {
			termList = getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		for (Terms iterator : termList) {
			String record = getString(iterator);
			System.out.println(record);
		}
	}

	private String getString(Terms term) {
		StringBuilder termRecord = new StringBuilder();
		termRecord.append(term.getId());
		termRecord.append(SEPERATOR);
		termRecord.append(term.getCondition());
		return termRecord.toString();
	}

	private List<Terms> getList() throws SQLException {
		List<Terms> termInfoList = new ArrayList<Terms>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM terms");
		while (resultSet.next()) {
			Terms term = new Terms();
			term.setId(resultSet.getInt(1));
			term.setCondition(resultSet.getInt(2));
			termInfoList.add(term);
		}
		return termInfoList;
	}

	public Terms getTermObject(ResultSet resultSet) throws SQLException {
		Integer getId = resultSet.getInt(5);
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		String queryString = "SELECT * FROM terms WHERE terms.id = " + String.valueOf(getId);
		ResultSet termResultSet = statement.executeQuery(queryString);
		termResultSet.next();
		Terms term = new Terms();
		term.setId(termResultSet.getInt(1));
		term.setCondition(termResultSet.getInt(2));
		return term;
	}
}
