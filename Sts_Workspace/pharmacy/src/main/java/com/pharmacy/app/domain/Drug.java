package com.pharmacy.app.domain;

public class Drug {
	private Long drugId;
	private String drugName;
	private String dosage;
	private String manufacturer;
	private String description;
	private Float price;
	private Long quantity;
	private String drugEntryDate;
	public Long getDrugId() {
		return drugId;
	}
	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getDrugEntryDate() {
		return drugEntryDate;
	}
	public void setDrugEntryDate(String drugEntryDate) {
		this.drugEntryDate = drugEntryDate;
	}
	@Override
	public String toString() {
		return "Drug [drugId=" + drugId + ", drugName=" + drugName
				+ ", dosage=" + dosage + ", manufacturer=" + manufacturer
				+ ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", drugEntryDate=" + drugEntryDate
				+ "]";
	}
}
