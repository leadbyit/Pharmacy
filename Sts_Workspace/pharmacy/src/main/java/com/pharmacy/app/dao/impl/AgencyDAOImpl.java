package com.pharmacy.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.app.dao.IAgencyDAO;
import com.pharmacy.app.domain.Agency;
import com.pharmacy.app.rowmapper.AgencyRowMapper;

@Repository("agencyDao")
public class AgencyDAOImpl implements IAgencyDAO {
	private static String LIST_ALL_AGENCIES = "SELECT * FROM PHARMACY.AGENCY";
	private static String INSERT_A_AGENCY = "INSERT INTO PHARMACY.AGENCY (AGENCYID, AGENCYNAME, TIN, CONTACTNAME, CITY, PHONENUMBER, ADDRESS) VALUE(?,?,?,?,?,?,?)";
	private static String GET_AGENCY_DETAILS = "SELECT * FROM PHARMACY.AGENCY WHERE AGENCYID = ?";
	private static String UPDATE_AGENCY_DETAILS = "UPDATE PHARMACY.AGENCY SET AGENCYNAME=?, TIN=?,CONTACTNAME=?,CITY=?,PHONENUMBER=?,ADDRESS=? WHERE AGENCYID=?";
	private static String DELETE_AGENCY_DETAILS = "DELETE FROM PHARMACY.AGENCY WHERE AGENCYID =?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void insertAgency(Agency agency) {
		getJdbcTemplate().update(
				INSERT_A_AGENCY,
				new Object[] { agency.getAgencyId(), agency.getAgencyName(),
						agency.getTinNumber(), agency.getContactName(),
						agency.getCity(), agency.getPhoneNumber(),
						agency.getAddress() });

	}

	@Override
	public void updateAgency(Agency agency) {
		getJdbcTemplate().update(
				UPDATE_AGENCY_DETAILS,
				new Object[] { agency.getAgencyName(), agency.getTinNumber(),
						agency.getContactName(), agency.getCity(),
						agency.getPhoneNumber(), agency.getAddress(),
						agency.getAgencyId() });

	}

	@Override
	public Agency getAgency(Long agencyID) {
		return getJdbcTemplate().queryForObject(GET_AGENCY_DETAILS,
				new Object[] { agencyID }, new AgencyRowMapper());

	}

	@Override
	public List<Agency> getAllAgencies() {
		return getJdbcTemplate().query(LIST_ALL_AGENCIES, new AgencyRowMapper());
	}

	@Override
	public void deleteAgency(Long agencyId) {
		getJdbcTemplate().update(DELETE_AGENCY_DETAILS, new Object[]{agencyId});
		
	}

}
