package com.pharmacy.app.services;

import java.util.List;

import com.pharmacy.app.domain.Drug;

public interface IDrugServices {

	public void addDrug(Drug drug);

	public void updateDrug(Drug drug);

	public Drug getDrug(Long drugID);

	public List<Drug> getAllDrugs();
	
	public void deleteDrug(Long drugId);

}
