package com.codeinsight.invoiceproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.invoiceproject.db.DbConnector;
import com.codeinsight.invoiceproject.entity.Products;

public class ProductsDAO {
	private final String SEPERATOR = " ";

	public void retrive() {
		List<Products> productList = null;
		try {
			productList = getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Products iterator : productList) {
			String record = getString(iterator);
			System.out.println(record);
		}

	}

	private String getString(Products product) {
		StringBuilder productRecord = new StringBuilder();
		productRecord.append(product.getId());
		productRecord.append(SEPERATOR);
		productRecord.append(product.getName());
		productRecord.append(SEPERATOR);
		productRecord.append(product.getPrice());
		productRecord.append(SEPERATOR);
		productRecord.append(product.getQuantity());
		productRecord.append(SEPERATOR);
		productRecord.append(product.getProperties());
		return productRecord.toString();
	}

	private List<Products> getList() throws SQLException {
		List<Products> productsList = new ArrayList<Products>();
		Connection connection = DbConnector.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
		while (resultSet.next()) {
			Products products = new Products();
			products.setId(resultSet.getInt(1));
			products.setName(resultSet.getString(2));
			products.setPrice(resultSet.getInt(3));
			products.setQuantity(resultSet.getInt(4));
			products.setProperties(resultSet.getString(5));
			productsList.add(products);
		}
		return productsList;
	}
}
