package com.pharmacy.app.domain;

import java.util.Date;

public class Invoice {
	private Long invoiceID;
	private Long agencyID;
	private String invoiceNumber;
	private Date invoiceDate;
	private Float invoiceAmount;
	private String agentName;
	private Date createDate;
	private Float balance;
	private Date lastModifiedDate;

	public Long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Long getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(Long agencyID) {
		this.agencyID = agencyID;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Float getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Float invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceID=" + invoiceID + ", agencyID=" + agencyID
				+ ", invoiceNumber=" + invoiceNumber + ", invoiceDate="
				+ invoiceDate + ", invoiceAmount=" + invoiceAmount
				+ ", agentName=" + agentName + ", createDate=" + createDate
				+ ", balance=" + balance + ", lastModifiedDate="
				+ lastModifiedDate + "]";
	}

}
