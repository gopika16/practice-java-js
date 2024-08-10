package com.codeinsight.csvsorter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	
	private final String SOURCE = "C:/Users/HP/Desktop/morning/emp1.csv";
	private final String DESTINATION = "C:/Users/HP/Desktop/morning/emp2.csv";

	public static void main(String[] args) {
		Application application = new Application();
		application.initialProcessing();
	}

	private void initialProcessing() {
		List<Employee> data = new ArrayList<Employee>();
		CsvReader csvReader = new CsvReader();
		try {
			data = csvReader.read(SOURCE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CsvSorter csvSorter = new CsvSorter();
		List<Employee> updatedData = new ArrayList<Employee>();
		updatedData = csvSorter.sort(data);

		CsvWriter csvWriter = new CsvWriter();
		try {
			csvWriter.write(updatedData, DESTINATION);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("DONE");
	}

}
