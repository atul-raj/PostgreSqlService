package com.hack.services;

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

//	public List<PowerGenData> listQuestion() {
//		TypedQuery<PowerGenData> query = em.createQuery("select u from Resources u", PowerGenData.class);
//		return query.getResultList();
//	}
	public List<PowerGenData> findByTurbine(String type) {
		return userResourcesServiceIfc.findByTurbine(type);
	}
	
	public List<PowerGenData> findBySite(String type) {
		return userResourcesServiceIfc.findBySite(type);
	}
	public List<PowerGenData> findByTemperatureBetweenAndInsertedTimeDateBetween(Long lower, Long upper, Date from, Date to){
		return userResourcesServiceIfc.findByTemperatureBetweenAndInsertedTimeDateBetween(lower, upper, from, to);
	}
	public List<PowerGenData> findByVoltageBetweenAndInsertedTimeDateBetween(Long lower, Long upper, Date from, Date to){
		return userResourcesServiceIfc.findByVoltageBetweenAndInsertedTimeDateBetween(lower, upper, from, to);
	}
	public List<PowerGenData> findByInsertedTimeDateBetween(Date from, Date to){
		return userResourcesServiceIfc.findByInsertedTimeDateBetween(from, to);
	}
}
