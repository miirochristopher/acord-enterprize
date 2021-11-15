package com.acord.repositories;

import com.acord.entity.SubCounty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCountyRepository extends JpaRepository<SubCounty, Long> {
	@Query("SELECT c.id,c.name FROM SubCounty s JOIN s.parishes AS c WHERE s.id=:id")
	List<Object[]> getParishesBySubCounty(Long id);
}
