package com.codeinsight.stocktrading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;
import com.codeinsight.stocktrading.io.CsvReader;
import com.codeinsight.stocktrading.io.CsvWriter;

public class UserInteractor {
	public void selectOperation() throws IOException {
		Scanner scanner = new Scanner(System.in);
		CsvReader csvReader = new CsvReader();
		List<Stocks> stocksList = new ArrayList<Stocks>();
		stocksList = csvReader.readStocks();
		List<Account> accountList = new ArrayList<Account>();
		accountList = csvReader.readAccounts();
		List<Holdings> holdingList = new ArrayList<Holdings>();
		holdingList = csvReader.readHoldings();

		while (true) {
			System.out.println("Enter your choice BUY(1) , SELL(2) or EXIT(0)");
			Integer userChoice = scanner.nextInt();
			if (userChoice == 1) {
				System.out.println("BUY");
				StockBuyer stockBuyer = new StockBuyer();
				stockBuyer.buyStock(stocksList, accountList, holdingList);
			} else if (userChoice == 2) {
				System.out.println("SELL");
				StockSeller stockSeller = new StockSeller();
				stockSeller.sellStock(stocksList, accountList, holdingList);
			} else if (userChoice == 0) {
				CsvWriter csvWriter = new CsvWriter();
				csvWriter.writeAccounts(accountList);
				csvWriter.writeHoldings(holdingList);
				csvWriter.writeStocks(stocksList);
				System.out.println("EXIT");
				System.exit(0);
			} else {
				System.out.println("--WRONG INPUT--");
			}
		}
	}
}
