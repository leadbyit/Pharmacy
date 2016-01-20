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

import com.pharmacy.app.domain.Agency;
import com.pharmacy.app.services.IAgencyServices;

@Controller
@RequestMapping(value="agency")
public class AgencyController {

	private static final Logger logger = LoggerFactory
			.getLogger(AgencyController.class);
	@Resource(name="agencyService")
	private IAgencyServices iAgencyService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String agencyHome()
	{
		return "agencyHome";
	}
	
	@RequestMapping(value="/displayallagencies", method=RequestMethod.GET)
	public @ResponseBody List<Agency> getAllAgencies()
	{
		logger.info("List all agencies");
		List<Agency> agencyList = iAgencyService.getAllAgencies();
		return agencyList;
	}
	
	@RequestMapping(value = "/createagency", method = RequestMethod.GET)
	public ModelAndView createAgencyPage() {
		return new ModelAndView("createAgencyForm", "agency", new Agency());
	}
	
	@RequestMapping(value = "/insertagency", method = RequestMethod.POST)
	public String insertDrug(@ModelAttribute Agency agency) {
		if (null != agency) {
			logger.info("One drug item {} will be inserted", agency);
			iAgencyService.addAgency(agency);
		}
		return "redirect:/agency/";
	}
	
	@RequestMapping(value = "/updateagency/{agencyId}", method = RequestMethod.GET)
	public String updateAgency(@PathVariable("agencyId") Long agencyId, Model model) {
		Agency agency = iAgencyService.getAgency(agencyId);
		if(null!= agency)
		{
			logger.info("Agency Found:{}", agency);
			model.addAttribute("agency", agency);
			return "updateAgencyForm";
		}
		return "redirect:/agency/";
	}
	
	@RequestMapping(value = "/updateagency", method = RequestMethod.POST)
	public String updateAgencyDetails(@ModelAttribute Agency agency) {
		if (null != agency) {
			logger.info("Ageny Details :{} will be updated", agency);
			iAgencyService.updateAgency(agency);
		}
		return "redirect:/agency/";
	}
	
	@RequestMapping(value = "/deleteagency/{agencyId}", method = RequestMethod.GET)
	public String deleteAgency(@PathVariable("agencyId") Long agencyId) {
		if (null != agencyId) {
			logger.info("Drug with Id {} will be deleted", agencyId);
			iAgencyService.deleteAgency(agencyId);
		}
		return "redirect:/agency/";
	}
}
