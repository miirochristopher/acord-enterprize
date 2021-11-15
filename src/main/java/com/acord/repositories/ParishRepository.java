package com.acord.repositories;

import com.acord.entity.Parish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParishRepository extends JpaRepository<Parish, Long> {
	@Query("SELECT c.id,c.name FROM Parish p JOIN p.villages AS c WHERE p.id=:id")
	List<Object[]> getVillagesByParish(Long id);
}
