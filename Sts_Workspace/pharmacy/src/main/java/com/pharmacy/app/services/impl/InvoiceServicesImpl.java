package com.pharmacy.app.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pharmacy.app.dao.IInvoiceDAO;
import com.pharmacy.app.domain.Invoice;
import com.pharmacy.app.services.IInvoiceServices;
@Service("invoiceService")
public class InvoiceServicesImpl implements IInvoiceServices {
	@Resource(name="invoiceDao")
	IInvoiceDAO iInvoiceDao;

	@Override
	public void addInvoice(Invoice invoice) {
		iInvoiceDao.addInvoice(invoice);

	}

	@Override
	public void updateInvoice(Invoice invoice) {
		iInvoiceDao.updateInvoice(invoice);

	}

	@Override
	public void deleteInvoice(Long invoiceId) {
		iInvoiceDao.deleteInvoice(invoiceId);

	}

	@Override
	public Invoice getInvoice(Long invoiceId) {
		return iInvoiceDao.getInvoice(invoiceId);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		return iInvoiceDao.listAllInvoices();
	}

}
