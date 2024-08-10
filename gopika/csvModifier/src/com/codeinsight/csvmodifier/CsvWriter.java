package com.codeinsight.csvmodifier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

	public void write(List<Employee> data, String destination) throws IOException {

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
			for (Employee iterator : data) {
				ObjectToStringConverter objectToStringConverter = new ObjectToStringConverter();
				String row = objectToStringConverter.convert(iterator);
				bufferedWriter.write(row);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
		}
	}

	
}
