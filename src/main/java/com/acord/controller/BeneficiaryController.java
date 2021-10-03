package com.acord.controller;

import com.acord.entity.Beneficiary;
import com.acord.services.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired
	public DataEntryService dataEntryService;

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("beneficiary", new Beneficiary());
		return "form";
	}

	@GetMapping("/list")
	public String list(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
		model.addAttribute("beneficiaries", dataEntryService.getBeneficiariesPage(pageNumber, size));
		return "list";
	}

	@PostMapping("/register")
	public String register(Beneficiary beneficiary, Model model) {
		dataEntryService.saveBeneficiary(beneficiary);
		model.addAttribute("beneficiary", beneficiary);
		return "saved";
	}

	@GetMapping("/edit/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		Beneficiary beneficiary = dataEntryService.getBeneficiaryById(id)
				.orElseThrow(() -> new IllegalArgumentException("Beneficiary with Id:" + id + "not found!!"));
		model.addAttribute("beneficiary", beneficiary);
		return "update";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") long id, @Valid Beneficiary beneficiary,
			BindingResult result) {
		if (result.hasErrors()) {
			beneficiary.setId(id);
			return "update";
		}
		dataEntryService.updateBeneficiary(beneficiary);
		return "redirect:/beneficiary/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		Beneficiary beneficiary = dataEntryService.getBeneficiaryById(id)
				.orElseThrow(() -> new IllegalArgumentException("Beneficiary with Id:" + id + "not found!!"));
		dataEntryService.deleteBeneficiary(beneficiary);
		return "redirect:/beneficiary/list";
	}
}
