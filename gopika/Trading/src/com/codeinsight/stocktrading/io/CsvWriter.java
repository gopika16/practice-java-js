package com.codeinsight.stocktrading.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;
import com.codeinsight.stocktrading.beans.UserDetails;

public class CsvWriter {
	private final String ACCOUNT_DESTINATION = "C:/Users/HP/Desktop/morning/accountNew.csv";
	private final String STOCKS_DESTINATION = "C:/Users/HP/Desktop/morning/stocksNew.csv";
	private final String HOLDING_DESTINATION = "C:/Users/HP/Desktop/morning/holdingsNew.csv";
	private final String USER_DESTINATION = "C:/Users/HP/Desktop/morning/userNew.csv";

	public void writeAccounts(List<Account> accountList) throws IOException {

		FileWriter fileWriter = new FileWriter(ACCOUNT_DESTINATION);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		try {
			for (Account iterator : accountList) {
				ObjectToStringConverter objectToStringConverter = new ObjectToStringConverter();
				String row = objectToStringConverter.convertAccount(iterator);
				bufferedWriter.write(row);
				bufferedWriter.newLine();
			}

		} finally {
			bufferedWriter.close();
		}

	}

	public void writeStocks(List<Stocks> stocksList) throws IOException {
		FileWriter fileWriter = new FileWriter(STOCKS_DESTINATION);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		try {
			for (Stocks iterator : stocksList) {
				ObjectToStringConverter objectToStringConverter = new ObjectToStringConverter();
				String row = objectToStringConverter.convertStocks(iterator);
				bufferedWriter.write(row);
				bufferedWriter.newLine();
			}

		} finally {
			bufferedWriter.close();
		}

	}

	public void writeHoldings(List<Holdings> holdingList) throws IOException {
		FileWriter fileWriter = new FileWriter(HOLDING_DESTINATION);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		try {
			for (Holdings iterator : holdingList) {
				ObjectToStringConverter objectToStringConverter = new ObjectToStringConverter();
				String row = objectToStringConverter.convertHoldings(iterator);
				bufferedWriter.write(row);
				bufferedWriter.newLine();
			}
		} finally {
			bufferedWriter.close();
		}

	}

	public void writeUser(List<UserDetails> userList) throws IOException {
		FileWriter fileWriter = new FileWriter(USER_DESTINATION);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		try {
			for (UserDetails iterator : userList) {
				ObjectToStringConverter objectToStringConverter = new ObjectToStringConverter();
				String row = objectToStringConverter.convertUser(iterator);
				bufferedWriter.write(row);
				bufferedWriter.newLine();
			}
		} finally {
			bufferedWriter.close();
		}

	}
}
