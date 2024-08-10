package com.codeinsight.stocktrading.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;
import com.codeinsight.stocktrading.beans.UserDetails;

public class CsvReader {
	private final String ACCOUNT_SOURCE = "C:/Users/HP/Desktop/morning/account.csv";
	private final String STOCKS_SOURCE = "C:/Users/HP/Desktop/morning/stocks.csv";
	private final String HOLDING_SOURCE = "C:/Users/HP/Desktop/morning/holdings.csv";
	private final String USER_SOURCE = "C:/Users/HP/Desktop/morning/user.csv";

	public List<Account> readAccounts() throws IOException {
		FileReader fileReader = new FileReader(ACCOUNT_SOURCE);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Account> accountData = new ArrayList<Account>();
		String row;
		while ((row = bufferedReader.readLine()) != null) {
			String[] getAccountArray = row.split(",");
			Account account = new Account();
			account.setAccountId(Integer.valueOf(getAccountArray[0]));
			account.setName(getAccountArray[1]);
			account.setTotalValue(Integer.valueOf(getAccountArray[2]));
			account.setCash(Integer.valueOf(getAccountArray[3]));
			accountData.add(account);
		}
		bufferedReader.close();
		return accountData;

	}

	public List<Stocks> readStocks() throws IOException {
		FileReader fileReader = new FileReader(STOCKS_SOURCE);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Stocks> stocksData = new ArrayList<Stocks>();
		String row;
		while ((row = bufferedReader.readLine()) != null) {
			String[] getStocksArray = row.split(",");
			Stocks stocks = new Stocks();
			stocks.setName(getStocksArray[0]);
			stocks.setShortCode(getStocksArray[1]);
			stocks.setPrice(Integer.valueOf(getStocksArray[2]));
			stocksData.add(stocks);
		}
		bufferedReader.close();
		return stocksData;

	}

	public List<Holdings> readHoldings() throws NumberFormatException, IOException {
		FileReader fileReader = new FileReader(HOLDING_SOURCE);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Holdings> holdingsData = new ArrayList<Holdings>();
		String row;
		while ((row = bufferedReader.readLine()) != null) {
			String[] getHoldingArray = row.split(",");
			Holdings holdings = new Holdings();
			holdings.setAccountId(getHoldingArray[0]);
			holdings.setShortcode(getHoldingArray[1]);
			holdings.setQuantity(Integer.valueOf(getHoldingArray[2]));
			holdings.setValue(Integer.valueOf(getHoldingArray[3]));
			holdingsData.add(holdings);
		}
		bufferedReader.close();
		return holdingsData;

	}

	public List<UserDetails> readUser() throws IOException {
		FileReader fileReader = new FileReader(USER_SOURCE);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<UserDetails> accountData = new ArrayList<UserDetails>();
		String row;
		while ((row = bufferedReader.readLine()) != null) {
			String[] array = row.split(",");
			UserDetails userDetails = new UserDetails();
			userDetails.setUserName(array[0]);
			userDetails.setCity(array[1]);
			userDetails.setCountry(array[2]);
			userDetails.setTotalCash(Integer.valueOf(array[3]));
			userDetails.setAccounts(Integer.valueOf(array[4]));
			accountData.add(userDetails);
		}
		bufferedReader.close();
		return accountData;

	}

}
