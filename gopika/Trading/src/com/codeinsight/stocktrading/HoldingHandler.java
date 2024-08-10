package com.codeinsight.stocktrading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codeinsight.stocktrading.beans.Account;
import com.codeinsight.stocktrading.beans.Holdings;
import com.codeinsight.stocktrading.beans.Stocks;

public class HoldingHandler {

	public List<Holdings> displayHolding(List<Holdings> holdingList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ShortCode : ");
		String shortCode = scanner.next();
		List<Holdings> stockHoldingList = new ArrayList<Holdings>();
		System.out.println("DISPLAY HOLDING : ");
		for (Holdings holding : holdingList) {
			String code = holding.getShortcode();
			if (code.equalsIgnoreCase(shortCode)) {
				System.out.println(holding.getAccountId() + " " + holding.getShortcode() + " " + holding.getQuantity()
						+ " " + holding.getValue());
				stockHoldingList.add(holding);
			}
		}
		return stockHoldingList;

	}

	public Holdings fetchHolding(Integer stockQuantity, Account accountDetails, List<Holdings> stockHoldingList) {
		Holdings holdingAccount = null;
		for (Holdings holding : stockHoldingList) {
			String getAccount = accountDetails.getName();
			String getHoldingAccount = holding.getAccountId();
			if (getHoldingAccount.equals(getAccount)) {
				holdingAccount = holding;
			}
		}
		return holdingAccount;
	}

	public Boolean verifyHolding(Integer stockQuantity, Account accountDetails, List<Holdings> stockHoldingList) {
		Boolean flag = false;
		Holdings holding = fetchHolding(stockQuantity, accountDetails, stockHoldingList);
		Integer checkQuantity = holding.getQuantity();
		if (checkQuantity >= stockQuantity) {
			flag = true;
		}
		return flag;
	}

	public void addEntry(Account accountDetails, Stocks stock, Integer stockQuantity, List<Holdings> holdingList)
			throws NumberFormatException, IOException {
		Holdings holdings = new Holdings();

		for (Holdings holding : holdingList) {
			String checkAccount = holding.getAccountId();
			String code = holding.getShortcode();
			String accountName = accountDetails.getName();
			String stockName = stock.getShortCode();
			if (checkAccount.equalsIgnoreCase(accountName) && (stockName.equalsIgnoreCase(code))) {
				Integer updateStock = holding.getQuantity() + stockQuantity;
				holding.setQuantity(updateStock);
				Integer updateValue = stockQuantity * stock.getPrice();
				holding.setValue(holding.getValue() + updateValue);
				System.out.println(holding.getAccountId() + " " + holding.getShortcode() + " " + holding.getValue()
						+ " " + holding.getQuantity());
				return;
			}
		}
		holdings.setAccountId(accountDetails.getName());
		holdings.setQuantity(stockQuantity);
		holdings.setShortcode(stock.getShortCode());
		Integer stockValue = stockQuantity * stock.getPrice();
		holdings.setValue(stockValue);

		holdingList.add(holdings);
		System.out.println(holdings.getAccountId() + " " + holdings.getShortcode() + " " + holdings.getValue() + " "
				+ holdings.getQuantity());
		System.out.println(holdings.getQuantity());
	}

	public void reduceQuantity(Integer stockQuantity, Account accountDetails, List<Holdings> stockHoldingList,
			Holdings holdingAccount) {
		Integer indexOfHolding = stockHoldingList.indexOf(holdingAccount);
		Holdings hold = stockHoldingList.get(indexOfHolding);
		Integer previousQuantity = hold.getQuantity();
		Integer stockPrice = hold.getValue() / previousQuantity;
		if (previousQuantity > stockQuantity) {
			Integer newQuantity = previousQuantity - stockQuantity;
			hold.setQuantity(newQuantity);
			hold.setValue(newQuantity * stockPrice);
		} else if (previousQuantity == stockQuantity) {
			stockHoldingList.remove(hold);
		}
		System.out.println("REDUCED HOLDING : " + holdingAccount.getAccountId() + " " + holdingAccount.getShortcode()
				+ " " + holdingAccount.getValue() + " " + holdingAccount.getQuantity());

	}
}
