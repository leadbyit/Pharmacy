package com.pharmacy.app.services;

import java.util.List;

import com.pharmacy.app.domain.InvoiceDrugs;

public interface IInvoiceDrugServices {
	
	public void addInvoiceDrugItem(InvoiceDrugs invoiceDrug);
	
	public void deleteInvoiceDrugItem(Long invoiceId, Long drugId, Long batchId);
	
	public void deleteInvoiceDrugItemWithInvoiceId(Long invoiceId);
	
	public void deleteInvoiceDrugItemWithDrugId(Long drugId);
	
	public List<InvoiceDrugs> getAllInvoiceDrugItems();
	
	public List<InvoiceDrugs> getAllInvoiceDrugItemsWithInvoiceId(Long invoiceId);
	
	public List<InvoiceDrugs> getAllInvoiceDrugItemsWithDrugId(Long drugId);
	
	public List<InvoiceDrugs> getAllInvoiceDrugItemsWithInvoiceIdAndDrugId(Long invoiceId, Long drugId);
	
	

}
