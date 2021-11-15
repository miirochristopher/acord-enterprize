package com.acord.services;

import com.acord.entity.SubCounty;
import com.acord.repositories.SubCountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCountyService {

	private final SubCountyRepository subcountyRepository;

	@Autowired
	public SubCountyService(SubCountyRepository subcountyRepository) {
		this.subcountyRepository = subcountyRepository;
	}

	public List<Object[]> getParishesBySubCounty(Long id){
		return subcountyRepository.getParishesBySubCounty(id);
	}

	public void save(SubCounty subCounty){
		subcountyRepository.save(subCounty);
	}

	public List<SubCounty> getAllSubcounties(){
		return this.subcountyRepository.findAll();
	}
}
