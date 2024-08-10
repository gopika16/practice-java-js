package com.codeinsight.stocktrading;

import java.io.IOException;
import java.util.List;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;

public class StockSeller {
	public void sellStock(List<Stocks> stocksList, List<Account> accountList, List<Holdings> holdingList)
			throws IOException {
		HoldingHandler holdingHandler = new HoldingHandler();
		List<Holdings> stockHoldingList = holdingHandler.displayHolding(holdingList);
		if (stockHoldingList.isEmpty()) {
			System.out.println("STOCK DOES NOT EXIST CHOOSE ANOTHER OPTION");
		} else {
			AccountHandler accountHandler = new AccountHandler();
			Account accountDetails = accountHandler.getAccountDetails(accountList);
			if (accountDetails == null) {
				System.out.println("ACCOUNT DOES NOT EXIST ");
			} else {
				StockHandler stockHandler = new StockHandler();
				Integer stockQuantity = stockHandler.getQuantity();
				Boolean verifyHolding = holdingHandler.verifyHolding(stockQuantity, accountDetails, stockHoldingList);
				if (verifyHolding) {
					Holdings holdingAccount = holdingHandler.fetchHolding(stockQuantity, accountDetails,
							stockHoldingList);
					holdingHandler.reduceQuantity(stockQuantity, accountDetails, holdingList, holdingAccount);
					accountHandler.increaseAccountValue(holdingAccount, accountDetails, stockQuantity);
				} else {
					System.out.println("--INSUFFICIENT HOLDINGS--");
				}
			}
		}
	}
}
