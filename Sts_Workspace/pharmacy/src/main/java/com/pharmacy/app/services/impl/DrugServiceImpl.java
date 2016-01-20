package com.pharmacy.app.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pharmacy.app.dao.IDrugDAO;
import com.pharmacy.app.domain.Drug;
import com.pharmacy.app.services.IDrugServices;

@Service("drugService")
public class DrugServiceImpl implements IDrugServices {
	@Resource(name="drugDao")
	private IDrugDAO iDrugDAO;

	@Override
	public void addDrug(Drug drug) {
		iDrugDAO.addDrug(drug);
	}

	@Override
	public void updateDrug(Drug drug) {
		iDrugDAO.updateDrug(drug);

	}

	@Override
	public Drug getDrug(Long drugID) {
		return iDrugDAO.getDrug(drugID);
	}

	@Override
	public List<Drug> getAllDrugs() {
		return iDrugDAO.getAllDrugs();
	}

	@Override
	public void deleteDrug(Long drugId) {
		iDrugDAO.deleteDrug(drugId);
		
	}

}
