package com.pharmacy.app.services;

import java.util.List;

import com.pharmacy.app.domain.Agency;

public interface IAgencyServices {
	public void addAgency(Agency agency);

	public void updateAgency(Agency agency);

	public Agency getAgency(Long agencyId);

	public List<Agency> getAllAgencies();
	
	public void deleteAgency(Long agencyId);
}
