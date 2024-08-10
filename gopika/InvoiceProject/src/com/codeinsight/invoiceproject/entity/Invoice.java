package com.codeinsight.invoiceproject.entity;

import java.sql.Date;

public class Invoice {
	private Integer id;
	private Date date;
	private Employee salesPersonId;
	private Employee accountsRecieverId;
	private Terms termsId;
	private Integer totalCost;
	private TaxInfo taxId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getSalesPersonId() {
		return salesPersonId;
	}

	public void setSalesPersonId(Employee salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	public Employee getAccountsRecieverId() {
		return accountsRecieverId;
	}

	public void setAccountsRecieverId(Employee accountsRecieverId) {
		this.accountsRecieverId = accountsRecieverId;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public TaxInfo getTaxId() {
		return taxId;
	}

	public void setTaxId(TaxInfo taxId) {
		this.taxId = taxId;
	}

	public Terms getTermsId() {
		return termsId;
	}

	public void setTermsId(Terms termsId) {
		this.termsId = termsId;
	}

}
