package com.pharmacy.app.domain;

import java.util.Date;

public class InvoiceDrugs {
	private Long invoiceID;
	private Long drugID;
	private Long quantity;
	private Date mfdDate;
	private Date expDate;
	private Float unitCost;
	private Float unitSellingPrice;
	private Float offer;
	private String offerDescription;
	private Long batchId;
	private String mfr;

	public Long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Long getDrugID() {
		return drugID;
	}

	public void setDrugID(Long drugID) {
		this.drugID = drugID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public Float getUnitSellingPrice() {
		return unitSellingPrice;
	}

	public void setUnitSellingPrice(Float unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}

	public Float getOffer() {
		return offer;
	}

	public void setOffer(Float offer) {
		this.offer = offer;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	
	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	@Override
	public String toString() {
		return "InvoiceDrugs [invoiceID=" + invoiceID + ", drugID=" + drugID
				+ ", quantity=" + quantity + ", mfdDate=" + mfdDate
				+ ", expDate=" + expDate + ", unitCost=" + unitCost
				+ ", unitSellingPrice=" + unitSellingPrice + ", offer=" + offer
				+ ", offerDescription=" + offerDescription + ", batchId="
				+ batchId + ", mfr=" + mfr + "]";
	}
	
	
}
