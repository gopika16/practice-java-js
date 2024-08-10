package com.codeinsight.stocktrading;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;

public class AccountHandler {
	public Account getAccountDetails(List<Account> accountList) throws IOException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Account Id : ");
		Integer userAccountId = scanner.nextInt();

		Account getAccount = null;

		for (Account account : accountList) {
			Integer getAccountId = account.getAccountId();
			if (getAccountId.equals(userAccountId)) {
				System.out.println(account.getName() + " " + account.getTotalValue() + " " + account.getAccountId()
						+ " " + account.getCash());
				getAccount = account;
			}
		}
		return getAccount;
	}

	public Boolean verifyAccount(Integer stockQuantity, Account accountDetails, Stocks stock) {
		Integer stockPrice = stock.getPrice();
		Integer stockTotalCost = stockQuantity * stockPrice;
		Boolean flag = false;
		if (accountDetails.getCash() >= stockTotalCost) {
			flag = true;
		}
		return flag;
	}

	public void decreaseAccountValue(Account accountDetails, Stocks stock, Integer stockQuantity) {
		Integer stockPrice = stock.getPrice();
		Integer stockTotalCost = stockQuantity * stockPrice;
		Integer getBalance = accountDetails.getCash();
		accountDetails.setCash(getBalance - stockTotalCost);
	}

	public void increaseAccountValue(Holdings holdingAccount, Account accountDetails, Integer stockQuantity) {
		Integer getStockValue = holdingAccount.getValue();
		Integer getStockCount = holdingAccount.getQuantity();
		Integer getStockPrice = getStockValue / getStockCount;
		Integer stockTotalCost = stockQuantity * getStockPrice;
		Integer getBalance = accountDetails.getCash();
		accountDetails.setCash(getBalance + stockTotalCost);
	}

}
