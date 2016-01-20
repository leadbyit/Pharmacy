package com.pharmacy.app.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pharmacy.app.dao.IInvoiceDrugsDAO;
import com.pharmacy.app.domain.InvoiceDrugs;
import com.pharmacy.app.services.IInvoiceDrugServices;

@Service("invoiceDrugService")
public class InvoiceDrugServicesImpl implements IInvoiceDrugServices{
	
	@Resource(name="invoiceDrugDao")
	private IInvoiceDrugsDAO invoiceDrugDao;
	@Override
	public void addInvoiceDrugItem(InvoiceDrugs invoiceDrug) {
		invoiceDrugDao.addInvoiceDrug(invoiceDrug);
		
	}

	@Override
	public void deleteInvoiceDrugItem(Long invoiceId, Long drugId, Long batchId) {
		invoiceDrugDao.deleteInvoiceDrug(invoiceId, drugId, batchId);
		
	}

	@Override
	public void deleteInvoiceDrugItemWithInvoiceId(Long invoiceId) {
		invoiceDrugDao.deleteInvoiceDrugWithInvoiceId(invoiceId);
		
	}

	@Override
	public void deleteInvoiceDrugItemWithDrugId(Long drugId) {
		invoiceDrugDao.deleteInvoiceDrugWithDrugId(drugId);
		
	}

	@Override
	public List<InvoiceDrugs> getAllInvoiceDrugItems() {
		return invoiceDrugDao.getAllInvoiceDrugs();
	}

	@Override
	public List<InvoiceDrugs> getAllInvoiceDrugItemsWithInvoiceId(Long invoiceId) {
		return invoiceDrugDao.getInvoiceDrugsWithInvoiceId(invoiceId);
	}

	@Override
	public List<InvoiceDrugs> getAllInvoiceDrugItemsWithDrugId(Long drugId) {
		return invoiceDrugDao.getInvoiceDrugWithDrugId(drugId);
	}

	@Override
	public List<InvoiceDrugs> getAllInvoiceDrugItemsWithInvoiceIdAndDrugId(
			Long invoiceId, Long drugId) {
		return invoiceDrugDao.getInvoiceDrugsWithInvoiceIdAndDrugId(invoiceId, drugId);
	}

}
