package com.codeinsight.csvsorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	public List<Employee> read(String source) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
		List<Employee> data = new ArrayList<Employee>();
		String row;
		while ((row = bufferedReader.readLine()) != null) {
			String[] array = row.split(",");
			Employee employee = new Employee();
			employee.setFirstName(array[0]);
			employee.setLastName(array[1]);
			employee.setAge(Integer.valueOf(array[2]));
			employee.setSalary(Integer.valueOf(array[3]));
			employee.setDepartment(array[4]);
			data.add(employee);
		}
		bufferedReader.close();
		return data;
	}
}
