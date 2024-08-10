package com.codeinsight.csvsorter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

	public void write(List<Employee> updatedData, String destination) throws IOException {

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
			for (Employee iterator : updatedData) {
				ObjectToStringConverter objectToStringConverter = new ObjectToStringConverter();
				String row = objectToStringConverter.convert(iterator);
				bufferedWriter.write(row);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
		}
	}
}
