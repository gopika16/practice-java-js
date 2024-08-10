package com.codeinsight.stocktrading;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.codeinsight.stocktrading.beans.Stocks;

public class StockHandler {
	public Stocks displayStock(List<Stocks> stocksList) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ShortCode : ");
		String shortCode = scanner.next();
		Stocks stockValue = null;
		for (Stocks stock : stocksList) {
			String code = stock.getShortCode();
			if (code.equalsIgnoreCase(shortCode)) {
				System.out.println(stock.getName() + " " + stock.getShortCode() + " " + stock.getPrice());
				stockValue = stock;
			}
		}
		return stockValue;
	}

	public Integer getQuantity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Stock Quantity : ");
		Integer getQuanity = scanner.nextInt();
		return getQuanity;
	}
}
