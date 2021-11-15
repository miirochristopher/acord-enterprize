package com.acord.controller;

import com.acord.entity.Beneficiary;
import com.acord.services.DataEntryService;
import com.acord.services.DistrictService;
import com.acord.services.ParishService;
import com.acord.services.SubCountyService;
import com.acord.services.VillageService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * The type Beneficiary controller.
 */
@Controller
@RequestMapping(value = "/beneficiary", method = { RequestMethod.GET, RequestMethod.POST })
public class BeneficiaryController {

	private final DataEntryService dataEntryService;
	private final DistrictService districtService;
	private final SubCountyService subCountyService;
	private final ParishService parishService;
	private final VillageService villageService;

	/**
	 * Instantiates a new Beneficiary controller.
	 *  @param dataEntryService the data entry service
	 * @param districtService the district service
	 * @param subCountyService the sub county service
	 * @param parishService the parish service
	 * @param villageService the village service
	 */
	@Autowired
	public BeneficiaryController(DataEntryService dataEntryService, DistrictService districtService,
			SubCountyService subCountyService, ParishService parishService, VillageService villageService) {
		this.dataEntryService = dataEntryService;
		this.districtService = districtService;
		this.subCountyService = subCountyService;
		this.parishService = parishService;
		this.villageService = villageService;
	}

	/**
	 * Form string.
	 *
	 * @param modelMap the model map
	 * @return the string
	 */
	@GetMapping("/form")
	public String form(ModelMap modelMap) {
		modelMap.addAttribute("beneficiary", new Beneficiary());
		modelMap.addAttribute("listOfDistricts", districtService.getAllDistricts());
		modelMap.addAttribute("listOfAllDistricts", districtService.findAllDistricts());
		modelMap.addAttribute("listOfSubcounties", subCountyService.getAllSubcounties());
		modelMap.addAttribute("listOfVillages", villageService.getAllVillages());
		return "form";
	}

	/**
	 * Get sub counties string.
	 *
	 * @param districtId the district id
	 * @return the string
	 */
	@ResponseBody
	@GetMapping("/form/subcounties")
	public String getSubCounties(@RequestParam Long districtId){
		Gson gson = new Gson();
		return gson.toJson(districtService.getSubCountiesByDistrict(districtId));
	}

	/**
	 * Get parishes string.
	 *
	 * @param subcountyId the subcounty id
	 * @return the string
	 */
	@ResponseBody
	@GetMapping("/form/parishes")
	public String getParishes(@RequestParam Long subcountyId){
		Gson gson = new Gson();
		return gson.toJson(subCountyService.getParishesBySubCounty(subcountyId));
	}

	/**
	 * Get villages string.
	 *
	 * @param parishId the parish id
	 * @return the string
	 */
	@ResponseBody
	@GetMapping("/form/villages")
	public String getVillages(@RequestParam Long parishId){
		Gson gson = new Gson();
		return gson.toJson(parishService.getVillagesByParish(parishId));
	}

	/**
	 * List string.
	 *
	 * @param pageNumber the page number
	 * @param size       the size
	 * @param model      the model
	 * @return the string
	 */
	@GetMapping("/list")
	public String list(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
		model.addAttribute("beneficiaries", dataEntryService.getBeneficiariesPage(pageNumber, size));
		return "list";
	}

	/**
	 * Register string.
	 *
	 * @param beneficiary the beneficiary
	 * @param model       the model
	 * @return the string
	 */
	@PostMapping("/register")
	public String register(Beneficiary beneficiary, Model model) {
		dataEntryService.saveBeneficiary(beneficiary);
		model.addAttribute("beneficiary", beneficiary);
		return "saved";
	}

	/**
	 * Update string.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/edit/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		Beneficiary beneficiary = dataEntryService.getBeneficiaryById(id)
				.orElseThrow(() -> new IllegalArgumentException("Beneficiary with Id:" + id + "not found!!"));
		model.addAttribute("beneficiary", beneficiary);
		return "update";
	}

	/**
	 * Update string.
	 *
	 * @param id          the id
	 * @param beneficiary the beneficiary
	 * @param result      the result
	 * @return the string
	 */
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") long id, @Valid Beneficiary beneficiary, BindingResult result) {
		if (result.hasErrors()) {
			beneficiary.setId(id);
			return "update";
		}
		dataEntryService.updateBeneficiary(beneficiary);
		return "redirect:/beneficiary/list";
	}

	/**
	 * Delete user string.
	 *
	 * @param id the id
	 * @return the string
	 */
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		Beneficiary beneficiary = dataEntryService.getBeneficiaryById(id)
				.orElseThrow(() -> new IllegalArgumentException("Beneficiary with Id:" + id + "not found!!"));
		dataEntryService.deleteBeneficiary(beneficiary);
		return "redirect:/beneficiary/list";
	}
}
