package com.pharmacy.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pharmacy.app.domain.Invoice;

public class InvoiceRowMapper implements RowMapper<Invoice>{

	@Override
	public Invoice mapRow(ResultSet rs, int i) throws SQLException {
		Invoice invoice = new Invoice();
		invoice.setAgencyID(rs.getLong("agencyid"));
		invoice.setAgentName(rs.getString("agentname"));
		invoice.setBalance(rs.getFloat("balance"));
		invoice.setCreateDate(rs.getDate("create_date"));
		invoice.setInvoiceAmount(rs.getFloat("invoiceamount"));
		invoice.setInvoiceDate(rs.getDate("invoicedate"));
		invoice.setInvoiceID(rs.getLong("invoiceid"));
		invoice.setInvoiceNumber(rs.getString("invoicenumber"));
		invoice.setLastModifiedDate(rs
				.getDate("last_modified_date"));
		return invoice;
	}

}
