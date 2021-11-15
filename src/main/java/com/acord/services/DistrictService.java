package com.acord.services;

import com.acord.entity.District;
import com.acord.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

	private final DistrictRepository districtRepository;

	@Autowired
	public DistrictService(DistrictRepository districtRepository) {
		this.districtRepository = districtRepository;
	}

	public List<Object[]> getAllDistricts(){
		return this.districtRepository.getAllDistricts();
	}

	public List<District> findAllDistricts(){
		return this.districtRepository.findAll();
	}

	public List<Object[]> getSubCountiesByDistrict(Long id){
		return this.districtRepository.getSubCountiesByDistrict(id);
	}

	public void save(District district){
		districtRepository.save(district);
	}
}
