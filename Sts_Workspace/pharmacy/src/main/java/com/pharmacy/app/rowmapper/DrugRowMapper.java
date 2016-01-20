package com.pharmacy.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pharmacy.app.domain.Drug;
import com.pharmacy.app.util.DateUtility;

public class DrugRowMapper implements RowMapper<Drug>{

	@Override
	public Drug mapRow(ResultSet rs, int i) throws SQLException {
		Drug drug = new Drug();
		drug.setDrugId(rs.getLong("drugid"));
		drug.setDescription(rs.getString("description"));
		drug.setDosage(rs.getString("dosage"));
		drug.setDrugEntryDate(DateUtility.convertToString(rs.getDate("drug_entry_date")));
		drug.setDrugName(rs.getString("drugname"));
		drug.setManufacturer(rs.getString("manufacturer"));
		drug.setPrice(rs.getFloat("price"));
		drug.setQuantity(rs.getLong("quantity"));
		return drug;
	}

}
