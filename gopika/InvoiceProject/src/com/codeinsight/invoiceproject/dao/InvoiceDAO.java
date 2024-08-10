package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.Employee;
import com.codeinsight.invoiceproject.entity.Invoice;

public class InvoiceDAO {
	private final String SEPERATOR = " ";

	public void retrive() {
		List<Invoice> invoiceList = null;
		try {
			invoiceList = getList();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Invoice iterator : invoiceList) {
			String record = getString(iterator);
			System.out.println(record);
		}

	}

	private String getString(Invoice invoice) {
		StringBuilder invoiceRecord = new StringBuilder();
		invoiceRecord.append(invoice.getId());
		invoiceRecord.append(SEPERATOR);
		invoiceRecord.append(invoice.getDate());
		invoiceRecord.append(SEPERATOR);
		String salesPersonName = invoice.getSalesPersonId().getName();
		invoiceRecord.append(salesPersonName);
		invoiceRecord.append(SEPERATOR);
		String accountsPersonName = invoice.getAccountsRecieverId().getName();
		invoiceRecord.append(accountsPersonName);
		invoiceRecord.append(SEPERATOR);
		Integer term = invoice.getTermsId().getCondition();
		invoiceRecord.append(term);
		invoiceRecord.append(SEPERATOR);
		Integer taxPercentage = invoice.getTaxId().getTaxPercentage();
		invoiceRecord.append(taxPercentage);
		invoiceRecord.append(SEPERATOR);
		invoiceRecord.append(invoice.getTotalCost());

		return invoiceRecord.toString();
	}

	private List<Invoice> getList() throws SQLException {
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM invoice");
		while (resultSet.next()) {
			Invoice invoice = new Invoice();
			invoice.setId(resultSet.getInt(1));
			invoice.setDate(resultSet.getDate(2));
			EmployeeDAO employeeDAO = new EmployeeDAO();
			Employee salesPersonDetails = employeeDAO.getEmployeeObject(resultSet.getInt(3));
			invoice.setSalesPersonId(salesPersonDetails);
			Employee AccountsPersonDetails = employeeDAO.getEmployeeObject(resultSet.getInt(4));
			invoice.setAccountsRecieverId(AccountsPersonDetails);
			TermsDAO termsDAO = new TermsDAO();
			invoice.setTermsId(termsDAO.getTermObject(resultSet));
			TaxInfoDAO taxInfoDAO = new TaxInfoDAO();
			invoice.setTaxId(taxInfoDAO.getTaxObject(resultSet));
			invoice.setTotalCost(resultSet.getInt(7));
			invoiceList.add(invoice);
		}
		return invoiceList;
	}
}
