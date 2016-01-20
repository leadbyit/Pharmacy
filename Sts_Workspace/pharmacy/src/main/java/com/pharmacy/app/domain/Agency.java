package com.pharmacy.app.domain;

public class Agency {
	private Long agencyId;
	private String agencyName;
	private String tinNumber;
	private String contactName;
	private String city;
	private String phoneNumber;
	private String address;
	
	
	public Long getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getTinNumber() {
		return tinNumber;
	}
	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Agency [agencyId=" + agencyId + ", agencyName=" + agencyName
				+ ", tinNumber=" + tinNumber + ", contactName=" + contactName
				+ ", city=" + city + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
}
