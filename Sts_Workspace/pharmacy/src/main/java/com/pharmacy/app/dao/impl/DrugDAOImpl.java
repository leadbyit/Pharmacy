package com.pharmacy.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.app.dao.IDrugDAO;
import com.pharmacy.app.domain.Drug;
import com.pharmacy.app.rowmapper.DrugRowMapper;
import com.pharmacy.app.util.DateUtility;
@Repository("drugDao")
public class DrugDAOImpl implements IDrugDAO {
	private static String LIST_ALL_DRUGS = "SELECT * FROM PHARMACY.DRUG";
	private static String INSERT_DRUG = "INSERT INTO PHARMACY.DRUG (DRUGID, DRUGNAME, DOSAGE, MANUFACTURER, DESCRIPTION, PRICE, QUANTITY, DRUG_ENTRY_DATE) VALUES(?,?,?,?,?,?,?,?)";
	private static String GET_A_DRUG = "SELECT * FROM PHARMACY.DRUG WHERE DRUGID = ?";
	private static String UPDATE_A_DRUG = "UPDATE PHARMACY.DRUG SET DRUGNAME = ?, DOSAGE= ?, MANUFACTURER= ?, DESCRIPTION=?, PRICE=?, QUANTITY=?, DRUG_ENTRY_DATE=? WHERE DRUGID= ?";
	private static String DELETE_A_DRUG = "DELETE FROM PHARMACY.DRUG WHERE DRUGID=?";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	@Override
	public void addDrug(Drug drug) {
		getJdbcTemplate().update(
				INSERT_DRUG,
				new Object[] { drug.getDrugId(), drug.getDrugName(),
						drug.getDosage(), drug.getManufacturer(),
						drug.getDescription(), drug.getPrice(),
						drug.getQuantity(), DateUtility.convertToDate(drug.getDrugEntryDate()) });
	}

	@Override
	public void updateDrug(Drug drug) {
		getJdbcTemplate().update(
				UPDATE_A_DRUG,
				new Object[] { drug.getDrugName(), drug.getDosage(),
						drug.getManufacturer(), drug.getDescription(),
						drug.getPrice(), drug.getQuantity(),
						DateUtility.convertToDate(drug.getDrugEntryDate()), drug.getDrugId() });
	}

	@Override
	public Drug getDrug(Long drugID) {
		return getJdbcTemplate().queryForObject(GET_A_DRUG,
				new Object[] { drugID }, new DrugRowMapper());
	}

	@Override
	public List<Drug> getAllDrugs() {
		return getJdbcTemplate().query(LIST_ALL_DRUGS, new DrugRowMapper());
	}

	@Override
	public void deleteDrug(Long drugId) {
		getJdbcTemplate().update(DELETE_A_DRUG, new Object[] { drugId });
	}

}
