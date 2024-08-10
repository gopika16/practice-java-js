package com.codeinsight.invoiceproject.entity;

public class ServiceInvoice {
	private Integer id ;
	private Invoice invoiceId ;
	private Services serviceId ;
	private Integer serviceHours ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Invoice getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Invoice invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Services getServiceId() {
		return serviceId;
	}
	public void setServiceId(Services serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getServiceHours() {
		return serviceHours;
	}
	public void setServiceHours(Integer serviceHours) {
		this.serviceHours = serviceHours;
	}
	
}
