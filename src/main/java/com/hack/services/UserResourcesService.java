package com.hack.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.repositories.UserResourcesServiceIfc;
import com.hack.repositories.entities.PowerGenData;

@Service
public class UserResourcesService {

	@Autowired
	UserResourcesServiceIfc userResourcesServiceIfc;

	@PersistenceContext
	private EntityManager em;

	public PowerGenData createQuestion(PowerGenData input) {
		return userResourcesServiceIfc.saveAndFlush(input);
	}

	public List<PowerGenData> findByTurbine(String type) {
		return userResourcesServiceIfc.findByTurbine(type);
	}
	
	public List<PowerGenData> findBySite(String type) {
		return userResourcesServiceIfc.findBySite(type);
	}
	public List<PowerGenData> findByTemperatureBetweenAndInsertedTimeDateBetween(BigDecimal lower, BigDecimal upper, Date from, Date to){
		return userResourcesServiceIfc.findByTemperatureBetweenAndInsertedDateDateBetween(lower, upper, from, to);
	}
	public List<PowerGenData> findByVoltageBetweenAndInsertedTimeDateBetween(BigDecimal lower, BigDecimal upper, Date from, Date to){
		return userResourcesServiceIfc.findByVoltageBetweenAndInsertedDateBetween(lower, upper, from, to);
	}
	public List<PowerGenData> findByInsertedTimeDateBetween(Date from, Date to){
		return userResourcesServiceIfc.findByInsertedDateBetween(from, to);
	}
}
