package com.acord.services;

import com.acord.entity.Beneficiary;
import com.acord.entity.paging.Paged;
import com.acord.entity.paging.Paging;
import com.acord.repositories.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataEntryService {

	private final BeneficiaryRepository beneficiaryRepository;

	@Autowired
	public DataEntryService(BeneficiaryRepository beneficiaryRepository) {
		this.beneficiaryRepository = beneficiaryRepository;
	}

	public Paged<Beneficiary> getBeneficiariesPage(int pageNumber, int size) {
		PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.by(Sort.Direction.ASC, "id"));
		Page<Beneficiary> postPage = beneficiaryRepository.findAll(request);
		return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
	}

	public Optional<Beneficiary> getBeneficiaryById(long id) {
		return this.beneficiaryRepository.findById(id);
	}

	public void saveBeneficiary(Beneficiary beneficiary) {
		this.beneficiaryRepository.save(beneficiary);
	}

	public void updateBeneficiary(Beneficiary beneficiary) {
		this.beneficiaryRepository.save(beneficiary);
	}

	public void deleteBeneficiary(Beneficiary beneficiary) {
		this.beneficiaryRepository.delete(beneficiary);
	}
}
