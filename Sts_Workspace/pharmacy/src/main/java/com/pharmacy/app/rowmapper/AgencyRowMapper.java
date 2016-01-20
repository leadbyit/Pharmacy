package com.pharmacy.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pharmacy.app.domain.Agency;

public class AgencyRowMapper implements RowMapper<Agency>{

	@Override
	public Agency mapRow(ResultSet rs, int rowNum) throws SQLException {
		Agency agency = new Agency();
		agency.setAddress(rs.getString("address"));
		agency.setAgencyId(rs.getLong("agencyid"));
		agency.setAgencyName(rs.getString("agencyname"));
		agency.setCity(rs.getString("city"));
		agency.setContactName(rs.getString("contactname"));
		agency.setPhoneNumber(rs.getString("phonenumber"));
		agency.setTinNumber(rs.getString("tin"));
		return agency;
	}

}
