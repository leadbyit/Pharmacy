package com.pharmacy.app.dao;

import java.util.List;

import com.pharmacy.app.domain.InvoiceDrugs;

public interface IInvoiceDrugsDAO {

	public void addInvoiceDrug(InvoiceDrugs invoiceDrug);

	public void deleteInvoiceDrug(Long invoiceId, Long drugId, Long batchId);

	public List<InvoiceDrugs> getInvoiceDrugsWithInvoiceId(Long invoiceId);

	public List<InvoiceDrugs> getInvoiceDrugWithDrugId(Long drugId);

	public List<InvoiceDrugs> getInvoiceDrugsWithInvoiceIdAndDrugId(
			Long invoiceId, Long drugId);

	public void deleteInvoiceDrugWithInvoiceId(Long invoiceId);

	public void deleteInvoiceDrugWithDrugId(Long drugId);
	
	public List<InvoiceDrugs> getAllInvoiceDrugs();

}
