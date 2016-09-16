package com.hack.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hack.repositories.entities.PowerGenData;

@Repository
@Transactional
public interface UserResourcesServiceIfc extends JpaRepository<PowerGenData, Long> {
//	List<PowerGenData> findByIdBeforeAndIdAfter(Long from, Long to);
	List<PowerGenData> findByTurbine(String type);
	List<PowerGenData> findBySite(String type);
	
	@Query(value="select * from powergen_data  where temperature between ?1 AND ?2 and inserted_date between ?3 AND ?4", nativeQuery = true)
	List<PowerGenData> findByTemperatureBetweenAndInsertedDateDateBetween(BigDecimal lower, BigDecimal upper, Date from, Date to);
	
	@Query(value="select * from powergen_data  where voltage between ?1 AND ?2 and inserted_date between ?3 AND ?4", nativeQuery = true)
	List<PowerGenData> findByVoltageBetweenAndInsertedDateBetween(BigDecimal lower, BigDecimal upper, Date from, Date to);
	
	@Query(value="select * from powergen_data  where inserted_date between ?1 AND ?2", nativeQuery = true)
	List<PowerGenData> findByInsertedDateBetween(Date from, Date to);
}
