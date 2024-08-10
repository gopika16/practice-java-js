package com.codeinsight.stocktrading;

import java.io.IOException;
import java.util.List;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;

public class StockBuyer {

	public void buyStock(List<Stocks> stocksList, List<Account> accountList, List<Holdings> holdingList)
			throws IOException {

		StockHandler stockHandler = new StockHandler();
		Stocks stock = stockHandler.displayStock(stocksList);
		if (stock == null) {
			System.out.println("STOCK DOES NOT EXIST CHOOSE ANOTHER OPTION");
		} else {
			AccountHandler accountHandler = new AccountHandler();
			Account accountDetails = accountHandler.getAccountDetails(accountList);
			if (accountDetails == null) {
				System.out.println("ACCOUNT DOES NOT EXIST ");
			} else {
				Integer stockQuantity = stockHandler.getQuantity();

				Boolean verifyAccount = accountHandler.verifyAccount(stockQuantity, accountDetails, stock);
				if (verifyAccount) {
					HoldingHandler holdingHandler = new HoldingHandler();
					holdingHandler.addEntry(accountDetails, stock, stockQuantity, holdingList);
					accountHandler.decreaseAccountValue(accountDetails, stock, stockQuantity);
				} else {
					System.out.println("-INSUFFICIENT BALANCE-");
					System.out.println("YOUR ACCOUNT BALANCE : " + accountDetails.getTotalValue());
				}
			}

		}

	}
}
