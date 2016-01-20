package com.pharmacy.app.dao;

import java.util.List;

import com.pharmacy.app.domain.Agency;

public interface IAgencyDAO {
	public void insertAgency(Agency agency);

	public void updateAgency(Agency agency);

	public Agency getAgency(Long agencyID);

	public List<Agency> getAllAgencies();
	
	public void deleteAgency(Long agencyId);
}
