package com.pharmacy.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pharmacy.app.dao.IInvoiceDAO;
import com.pharmacy.app.domain.Invoice;
import com.pharmacy.app.rowmapper.InvoiceRowMapper;
@Repository("invoiceDao")
public class InvoiceDAOImpl implements IInvoiceDAO {
	private static String LIST_ALL_INVOICE = "SELECT * FROM PHARMACY.INVOICE";
	private static String INSERT_A_INVOICE = "INSERT INTO PHARMACY.INVOICE (INVOICEID, AGENCYID, INVOICENUMBER, INVOICEDATE, INVOICEAMOUNT, AGENENTNAME, CREATE_DATE, BALANCE, LAST_MODIFIED_DATE) VALUES(?,?,?,?,?,?,?,?,?)";
	private static String DELETE_A_INVOICE = "DELETE FROM PHARMACY.INVOICE WHERE INVOICEID=?";
	private static String UPDATE_A_INVOICE = "UPDATE PHARMACY.INVOICE SET AGENCYID=?, INVOICENUMBER=?, INVOICEDATE=?, INVOICEAMOUNT=?, AGENENTNAME=?, CREATE_DATE=?, BALANCE=?, LAST_MODIFIED_DATE=? WHERE INVOICEID=?";
	private static String GET_A_INVOICE = "SELECT * FROM PHARMACY.INVOICE WHERE INVOICEID=?";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void addInvoice(Invoice invoice) {
		getJdbcTemplate().update(
				INSERT_A_INVOICE,
				new Object[] { invoice.getInvoiceID(), invoice.getAgencyID(),
						invoice.getInvoiceNumber(), invoice.getInvoiceDate(),
						invoice.getInvoiceAmount(), invoice.getAgentName(),
						invoice.getCreateDate(), invoice.getBalance(),
						invoice.getLastModifiedDate() });
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		getJdbcTemplate().update(
				UPDATE_A_INVOICE,
				new Object[] { invoice.getInvoiceID(), invoice.getAgencyID(),
						invoice.getInvoiceNumber(), invoice.getInvoiceDate(),
						invoice.getInvoiceAmount(), invoice.getAgentName(),
						invoice.getCreateDate(), invoice.getBalance(),
						invoice.getLastModifiedDate() });
	}

	@Override
	public void deleteInvoice(Long invoiceId) {
		getJdbcTemplate().update(DELETE_A_INVOICE, new Object[] { invoiceId });
	}

	@Override
	public List<Invoice> listAllInvoices() {
		return getJdbcTemplate()
				.query(LIST_ALL_INVOICE, new InvoiceRowMapper());
	}

	@Override
	public Invoice getInvoice(Long invoiceId) {
		return getJdbcTemplate().queryForObject(GET_A_INVOICE,
				new Object[] { invoiceId }, new InvoiceRowMapper());
	}

}
