package com.pharmacy.app.dao;

import java.util.List;

import com.pharmacy.app.domain.Invoice;

public interface IInvoiceDAO {
	
	public void addInvoice(Invoice invoice);

	public void updateInvoice(Invoice invoice);

	public void deleteInvoice(Long invoiceId);
	
	public List<Invoice> listAllInvoices();
	
	public Invoice getInvoice(Long invoiceId);

}
