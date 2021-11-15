package com.acord.services;

import com.acord.entity.Village;
import com.acord.repositories.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageService {

	private final VillageRepository villageRepository;

	@Autowired
	public VillageService(VillageRepository villageRepository) {
		this.villageRepository = villageRepository;
	}

	public void save(Village  village){
		villageRepository.save(village);
	}

	public List<Village> getAllVillages(){
		return this.villageRepository.findAll();
	}
}
