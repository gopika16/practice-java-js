package com.codeinsight.csvsorter;

import java.util.Comparator;

public class SalarySorter implements Comparator<Employee> {
	@Override
	public int compare(Employee employeeOne, Employee employeeTwo) {
		return employeeOne.getSalary() - employeeTwo.getSalary() ;
	}

}
