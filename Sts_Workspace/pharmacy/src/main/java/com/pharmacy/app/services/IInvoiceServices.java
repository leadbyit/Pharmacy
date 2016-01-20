package com.pharmacy.app.services;

import java.util.List;

import com.pharmacy.app.domain.Invoice;

public interface IInvoiceServices {

	public void addInvoice(Invoice invoice);

	public void updateInvoice(Invoice invoice);

	public void deleteInvoice(Long invoiceId);

	public Invoice getInvoice(Long invoiceId);

	public List<Invoice> getAllInvoices();

}
