package com.pharmacy.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pharmacy.app.domain.Invoice;
import com.pharmacy.app.services.IDrugServices;
import com.pharmacy.app.services.IInvoiceServices;

@Controller
@RequestMapping(value="invoice")
public class InvoiceController {
	@Resource(name="invoiceService")
	private IInvoiceServices invoiceService;
	@Resource(name="drugService")
	private IDrugServices iDrugService;
	
	@RequestMapping(value="/displayallinvoices",method=RequestMethod.GET)
	public ModelAndView getAllInvoices()
	{
		ModelAndView mav = new ModelAndView();
		List<Invoice> invoices = invoiceService.getAllInvoices();
		mav.addObject("invoices", invoices);
		mav.setViewName("listAllinvoices");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String invoiceHome()
	{
		return "invoiceHome";
	}
	
	

}
