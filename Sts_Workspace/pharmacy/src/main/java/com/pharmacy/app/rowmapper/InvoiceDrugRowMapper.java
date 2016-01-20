package com.pharmacy.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pharmacy.app.domain.InvoiceDrugs;

public class InvoiceDrugRowMapper implements RowMapper<InvoiceDrugs>{

	@Override
	public InvoiceDrugs mapRow(ResultSet rs, int i) throws SQLException {
		InvoiceDrugs invoiceDrug = new InvoiceDrugs();
		invoiceDrug.setBatchId(rs.getLong("batchid"));
		invoiceDrug.setDrugID(rs.getLong("drugid"));
		invoiceDrug.setExpDate(rs.getDate("expdate"));
		invoiceDrug.setInvoiceID(rs.getLong("invoiceid"));
		invoiceDrug.setMfdDate(rs.getDate("mfddate"));
		invoiceDrug.setMfr(rs.getString("mfr"));
		invoiceDrug.setOffer(rs.getFloat("offer"));
		invoiceDrug.setOfferDescription(rs.getString("offer_description"));
		invoiceDrug.setQuantity(rs.getLong("quantity"));
		invoiceDrug.setUnitCost(rs.getFloat("unitcost"));
		invoiceDrug.setUnitSellingPrice(rs.getFloat("unitsellingprice"));
		return invoiceDrug;
	}

}
