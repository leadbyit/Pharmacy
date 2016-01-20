package com.pharmacy.app.dao;

import java.util.List;

import com.pharmacy.app.domain.Drug;

public interface IDrugDAO {

	public void addDrug(Drug drug);

	public void updateDrug(Drug drug);

	public Drug getDrug(Long drugID);

	public List<Drug> getAllDrugs();
	
	public void deleteDrug(Long drugId);

}
