package com.codeinsight.invoiceproject.entity;



public class TaxInfo {
	private Integer id ;
	private String name ;
	private Integer taxPercentage ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(Integer taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	
}
