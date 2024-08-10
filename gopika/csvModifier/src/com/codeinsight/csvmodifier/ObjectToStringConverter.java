package com.codeinsight.csvmodifier;

public class ObjectToStringConverter {
	public String convert(Employee employee) {
		StringBuilder firstName = new StringBuilder(employee.getFirstName());
		StringBuilder lastName = new StringBuilder(employee.getLastName());
		StringBuilder age = new StringBuilder(String.valueOf(employee.getAge()));
		StringBuilder salary = new StringBuilder(String.valueOf(employee.getSalary()));
		StringBuilder department = new StringBuilder(employee.getDepartment());
		String employeeRecord = firstName + "," + lastName + "," + age + "," + salary + "," + department;
		return employeeRecord;
	}

}
