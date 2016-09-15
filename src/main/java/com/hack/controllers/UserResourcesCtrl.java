package com.hack.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hack.repositories.UserResourcesServiceIfc;
import com.hack.repositories.entities.PowerGenData;
import com.hack.services.UserResourcesService;

@RestController
@RequestMapping("/api/v1/pgd")
public class UserResourcesCtrl {
	
	@Autowired
	UserResourcesServiceIfc userResourcesServiceIfc;
	
	@Autowired
	UserResourcesService userResourcesService;
	
	@RequestMapping(name="/", method=RequestMethod.GET)
	public String getHello(){
		return "String hello world from the service";
	}
	
	@RequestMapping(name="/", method=RequestMethod.POST)
	public PowerGenData createResource(@RequestBody PowerGenData input){
		return userResourcesServiceIfc.saveAndFlush(input);
	}
	
	@RequestMapping("/all")
	public List<PowerGenData> getPowerData(){
		return userResourcesServiceIfc.findAll();
	}
	
	@RequestMapping("/id/{id}")
	public PowerGenData getResourcesById(@PathVariable Long id){
		return userResourcesServiceIfc.findOne(id);
	}
	
	@RequestMapping("/turbine/{turbine}")
	public List<PowerGenData> getTurbineData(@PathVariable String turbine){
		return userResourcesService.findByTurbine(turbine);
	}
	
	@RequestMapping("/site/{site}")
	public List<PowerGenData> findBySite(String site) {
		return userResourcesService.findBySite(site);
	}
	
	@RequestMapping("/tem/{lower}/{upper}/date/{from}/{to}")
	public List<PowerGenData> findByTemperatureBetweenAndInsertedTimeDateBetween(Long lower, Long upper, Date from, Date to){
		return userResourcesService.findByTemperatureBetweenAndInsertedTimeDateBetween(lower, upper, from, to);
	}
	
	@RequestMapping("/vol/{lower}/{upper}/date/{from}/{to}")
	public List<PowerGenData> findByVoltageBetweenAndInsertedTimeDateBetween(Long lower, Long upper, Date from, Date to){
		return userResourcesService.findByVoltageBetweenAndInsertedTimeDateBetween(lower, upper, from, to);
	}
	
	@RequestMapping("/date/{from}/{to}")
	public List<PowerGenData> findByInsertedTimeDateBetween(Date from, Date to){
		return userResourcesService.findByInsertedTimeDateBetween(from, to);
	}
	
}
