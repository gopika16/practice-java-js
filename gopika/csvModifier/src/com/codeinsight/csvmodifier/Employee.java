package com.codeinsight.csvmodifier;

public class Employee {
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer salary;
	private String department;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

}
