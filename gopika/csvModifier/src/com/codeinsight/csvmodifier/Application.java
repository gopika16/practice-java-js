package com.codeinsight.csvmodifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	private final String source = "C:/Users/HP/Desktop/morning/emp1.csv";
	private final String destination = "C:/Users/HP/Desktop/morning/emp2.csv";

	public static void main(String[] args) {
		Application application = new Application();
		application.initialProcessing();
	}

	private void initialProcessing() {
		List<Employee> data = new ArrayList<Employee>();
		CsvReader csvReader = new CsvReader();
		try {
			data = csvReader.read(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CsvUpdater csvUpdater = new CsvUpdater();
		List<Employee> updatedData = new ArrayList<Employee>();
		updatedData = csvUpdater.update(data);
		
		CsvWriter csvWriter = new CsvWriter(); 
		try {
			csvWriter.write(updatedData, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("DONE");
	}

}
