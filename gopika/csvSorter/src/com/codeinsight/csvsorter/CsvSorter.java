package com.codeinsight.csvsorter;

import java.util.Collections;
import java.util.List;

public class CsvSorter {
	public List<Employee> sort(List<Employee> data) {
		Collections.sort(data, new SalarySorter().reversed());
		return data;
	}
}
