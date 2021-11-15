package com.acord.repositories;

import com.acord.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
	@Query("SELECT d.id,d.name FROM District d")
	List<Object[]> getAllDistricts();

	@Query("SELECT s.id,s.name FROM District d JOIN d.subcounties AS s WHERE d.id=:id")
	List<Object[]> getSubCountiesByDistrict(Long id);
}

