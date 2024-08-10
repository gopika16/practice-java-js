package com.codeinsight.csvmodifier;

import java.util.ArrayList;
import java.util.List;

public class CsvUpdater {
	private final Integer salaryIncrement = 2000;

	public List<Employee> update(List<Employee> data) {
		List<Employee> updatedData = new ArrayList<Employee>();
		for (Employee row : data) {
			Integer getSalary = row.getSalary();
			Integer incrementSalary = getSalary + salaryIncrement;
			row.setSalary(incrementSalary);
			updatedData.add(row);
		}
		return updatedData;

	}
}
