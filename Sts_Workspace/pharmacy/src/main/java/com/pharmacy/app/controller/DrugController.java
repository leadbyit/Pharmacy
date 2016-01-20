package com.pharmacy.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pharmacy.app.domain.Drug;
import com.pharmacy.app.services.IDrugServices;

@Controller
@RequestMapping(value="drugs")
public class DrugController {

	private static final Logger logger = LoggerFactory
			.getLogger(DrugController.class);
	@Resource(name = "drugService")
	private IDrugServices drugService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String drugHome()
	{
		return "drugHome";
	}
	
	@RequestMapping(value = "displayalldrugs", method = RequestMethod.GET)
	public  @ResponseBody List<Drug>  getAllDrugs() {
		logger.info("List All Drugs");
		return drugService.getAllDrugs();
	}

	@RequestMapping(value = "createdrug", method = RequestMethod.GET)
	public ModelAndView createDrugPage() {
		return new ModelAndView("createDrugForm", "drug", new Drug());
	}

	@RequestMapping(value = "insertdrug", method = RequestMethod.POST)
	public String insertDrug(@ModelAttribute Drug drug) {
		if (null != drug) {
			logger.info("One drug item {} will be inserted", drug);
			drugService.addDrug(drug);
		}
		return "redirect:/drugs/";
	}

	@RequestMapping(value = "updatedrug/{drugId}", method = RequestMethod.GET)
	public String updateDrug(@PathVariable("drugId") Long drugId, Model model) {
		Drug drug = drugService.getDrug(drugId);
		if(null!= drug)
		{
			logger.info("Drug Found:{}", drug);
			model.addAttribute("drug", drug);
			return "updateDrugForm";
		}
		return "redirect:/drugs/";
	}
	
	@RequestMapping(value = "updatedrug", method = RequestMethod.POST)
	public String updateDrugItem(@ModelAttribute Drug drug) {
		if (null != drug) {
			logger.info("Drug Item :{} will be updated", drug);
			drugService.updateDrug(drug);
		}
		return "redirect:/drugs/";
	}

	@RequestMapping(value = "deletedrug/{drugId}", method = RequestMethod.GET)
	public String deleteDrug(@PathVariable("drugId") Long drugId) {
		if (null != drugId) {
			logger.info("Drug with Id {} will be deleted", drugId);
			drugService.deleteDrug(drugId);
		}
		return "redirect:/drugs/";
	}
}
