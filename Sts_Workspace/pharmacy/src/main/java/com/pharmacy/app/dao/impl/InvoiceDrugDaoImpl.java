package com.pharmacy.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.app.dao.IInvoiceDrugsDAO;
import com.pharmacy.app.domain.InvoiceDrugs;
import com.pharmacy.app.rowmapper.InvoiceDrugRowMapper;

@Repository("invoiceDrugDao")
public class InvoiceDrugDaoImpl implements
		IInvoiceDrugsDAO {

	private static String INSERT_A_INVOICE_DRUG = "INSERT INTO PHARMACY.INVOICE_DRUG (INVOICEID, DRUGID, QUANTITY, MFDDATE, EXPDATE, UNITCOST, UNITSELLINGPRICE, OFFER, OFFER_DESCRIPTION, BATCHID, MFR) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static String GET_A_INVOICE_DRUG_WITH_INVOICEID = "SELECT * FROM PHARMACY.INVOICE_DRUG WHERE INVOICEID = ?";
	private static String GET_A_INVOICE_DRUG_WITH_DRUGID = "SELECT * FROM PHARMACY.INVOICE_DRUG WHERE DRUGID=?";
	private static String GET_A_INVOICE_DRUG_WITH_INVOICEID_DRUGID = "SELECT * FROM PHARMACY.INVOICE_DRUG WHERE INVOICEID=? AND DRUGID=?";
	private static String DELETE_FROM_INVOICE_DRUG_WITH_INVOICEID_DRUGID_BATCHID = "DELETE FROM PHARMACY.INVOICE_DRUG WHERE INVOICEID=? AND DRUGID=?, BATCHID=?";
	private static String DELETE_FROM_INVOICE_DRUG_WITH_INVOICEID = "DELETE FROM PHARMACY.INVOICE_DRUG WHERE INVOICEID=?";
	private static String DELETE_FROM_INVOICE_DRUG_WITH_DRUGID = "DELETE FROM PHARMACY.INVOICE_DRUG WHERE DRUGID=?";
	private static String GET_ALL_INVOICE_DRUG_ITEMS = "SELECT * FROM PHARMACY.INVOICE_DRUG";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void addInvoiceDrug(InvoiceDrugs invoiceDrug) {
		getJdbcTemplate().update(
				INSERT_A_INVOICE_DRUG,
				new Object[] { invoiceDrug.getInvoiceID(),
						invoiceDrug.getDrugID(), invoiceDrug.getQuantity(),
						invoiceDrug.getMfdDate(), invoiceDrug.getExpDate(),
						invoiceDrug.getUnitCost(),
						invoiceDrug.getUnitSellingPrice(),
						invoiceDrug.getOffer(),
						invoiceDrug.getOfferDescription(),
						invoiceDrug.getBatchId(), invoiceDrug.getMfr() });
	}

	@Override
	public void deleteInvoiceDrug(Long invoiceId, Long drugId, Long batchId) {
		getJdbcTemplate().update(
				DELETE_FROM_INVOICE_DRUG_WITH_INVOICEID_DRUGID_BATCHID,
				new Object[] { invoiceId, drugId, batchId });
	}

	@Override
	public List<InvoiceDrugs> getInvoiceDrugsWithInvoiceId(Long invoiceId) {
		return getJdbcTemplate().query(GET_A_INVOICE_DRUG_WITH_INVOICEID,
				new Object[] { invoiceId }, new InvoiceDrugRowMapper());
	}

	@Override
	public List<InvoiceDrugs> getInvoiceDrugWithDrugId(Long drugId) {
		return getJdbcTemplate().query(GET_A_INVOICE_DRUG_WITH_DRUGID,
				new Object[] { drugId }, new InvoiceDrugRowMapper());
	}

	@Override
	public List<InvoiceDrugs> getInvoiceDrugsWithInvoiceIdAndDrugId(
			Long invoiceId, Long drugId) {
		return getJdbcTemplate().query(
				GET_A_INVOICE_DRUG_WITH_INVOICEID_DRUGID,
				new Object[] { invoiceId, drugId }, new InvoiceDrugRowMapper());
	}

	@Override
	public void deleteInvoiceDrugWithInvoiceId(Long invoiceId) {
		getJdbcTemplate().update(DELETE_FROM_INVOICE_DRUG_WITH_INVOICEID, new Object[]{invoiceId});
	}

	@Override
	public void deleteInvoiceDrugWithDrugId(Long drugId) {
		getJdbcTemplate().update(DELETE_FROM_INVOICE_DRUG_WITH_DRUGID, new Object[]{drugId});
		
	}

	@Override
	public List<InvoiceDrugs> getAllInvoiceDrugs() {
		return getJdbcTemplate().query(GET_ALL_INVOICE_DRUG_ITEMS, new InvoiceDrugRowMapper());
	}

}
