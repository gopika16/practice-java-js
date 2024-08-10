package com.codeinsight.printGreetings;

public class GreetingPrinter {
	
	//greeting function definition
	private void printGreeting() {
		System.out.println("hi! Have a Great day");
	}
	
	
	public static void main(String[] args) {
		
		GreetingPrinter greetingPrinter = new GreetingPrinter();
		
		//calling greeting method
		greetingPrinter.printGreeting();
		
	}
}
