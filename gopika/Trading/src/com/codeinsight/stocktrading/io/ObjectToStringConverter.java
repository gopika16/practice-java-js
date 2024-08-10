package com.codeinsight.stocktrading.io;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;
import com.codeinsight.stocktrading.beans.UserDetails;

public class ObjectToStringConverter {
	private final String SEPERATOR_COMMA = ",";

	public String convertAccount(Account account) {
		StringBuilder accountRecord = new StringBuilder();
		accountRecord.append(account.getAccountId());
		accountRecord.append(SEPERATOR_COMMA);
		accountRecord.append(account.getName());
		accountRecord.append(SEPERATOR_COMMA);
		accountRecord.append(account.getTotalValue());
		accountRecord.append(SEPERATOR_COMMA);
		accountRecord.append(account.getCash());
		return accountRecord.toString();
	}

	public String convertStocks(Stocks stock) {
		StringBuilder stockRecord = new StringBuilder();
		stockRecord.append(stock.getName());
		stockRecord.append(SEPERATOR_COMMA);
		stockRecord.append(stock.getShortCode());
		stockRecord.append(SEPERATOR_COMMA);
		stockRecord.append(stock.getPrice());
		return stockRecord.toString();
	}

	public String convertHoldings(Holdings holding) {
		StringBuilder holdingRecord = new StringBuilder();
		holdingRecord.append(holding.getAccountId());
		holdingRecord.append(SEPERATOR_COMMA);
		holdingRecord.append(holding.getShortcode());
		holdingRecord.append(SEPERATOR_COMMA);
		holdingRecord.append(holding.getQuantity());
		holdingRecord.append(SEPERATOR_COMMA);
		holdingRecord.append(holding.getValue());
		return holdingRecord.toString();
	}

	public String convertUser(UserDetails iterator) {
		return null;
	}

}
