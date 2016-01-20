package com.pharmacy.app.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pharmacy.app.dao.IAgencyDAO;
import com.pharmacy.app.domain.Agency;
import com.pharmacy.app.services.IAgencyServices;

@Service("agencyService")
public class AgencyServicesImpl implements IAgencyServices {

	@Resource(name="agencyDao")
	private IAgencyDAO iAgencyDAO;
	
	@Override
	public void addAgency(Agency agency) {
		iAgencyDAO.insertAgency(agency);
	}

	@Override
	public void updateAgency(Agency agency) {
		iAgencyDAO.updateAgency(agency);

	}

	@Override
	public Agency getAgency(Long agencyId) {
		
		return iAgencyDAO.getAgency(agencyId);
	}

	@Override
	public List<Agency> getAllAgencies() {
		return iAgencyDAO.getAllAgencies();
	}

	@Override
	public void deleteAgency(Long agencyId) {
		iAgencyDAO.deleteAgency(agencyId);
		
	}

}
