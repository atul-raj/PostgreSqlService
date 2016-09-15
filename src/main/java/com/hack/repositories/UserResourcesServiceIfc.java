package com.hack.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hack.repositories.entities.PowerGenData;

@Repository
@Transactional
public interface UserResourcesServiceIfc extends JpaRepository<PowerGenData, Long> {
//	List<PowerGenData> findByIdBeforeAndIdAfter(Long from, Long to);
	List<PowerGenData> findByTurbine(String type);
	List<PowerGenData> findBySite(String type);
	
	List<PowerGenData> findByTemperatureBetweenAndInsertedTimeDateBetween(Long lower, Long upper, Date from, Date to);
	List<PowerGenData> findByVoltageBetweenAndInsertedTimeDateBetween(Long lower, Long upper, Date from, Date to);
	
	List<PowerGenData> findByInsertedTimeDateBetween(Date from, Date to);
}
