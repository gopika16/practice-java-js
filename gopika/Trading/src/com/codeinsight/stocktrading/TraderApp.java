package com.codeinsight.stocktrading;

import java.io.IOException;

public class TraderApp {

	public static void main(String[] args) {
		UserInteractor userInteractor = new UserInteractor();
		try {
			userInteractor.selectOperation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
