package com.acord.services;

import com.acord.entity.Parish;
import com.acord.repositories.ParishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParishService {

	private final ParishRepository parishRepository;

	@Autowired
	public ParishService(ParishRepository parishRepository) {
		this.parishRepository = parishRepository;
	}

	public List<Object[]> getVillagesByParish(Long id){
		return parishRepository.getVillagesByParish(id);
	}

	public void save(Parish parish){
		parishRepository.save(parish);
	}
}
