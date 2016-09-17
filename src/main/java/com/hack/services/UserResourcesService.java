package com.hack.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hack.repositories.UserResourcesServiceIfc;
import com.hack.repositories.entities.ChartData;
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

	public List<PowerGenData> getTurbineData(String site,String turbine,Date from, Date to){
		return userResourcesServiceIfc.getTurbineData(site,turbine,from, to);
	}
	public List<PowerGenData> getSiteData(String site,Date from, Date to){
		return userResourcesServiceIfc.getSiteData(site,from, to);
	}
	public List<ChartData> getChartData(Date from, Date to){
		List<PowerGenData> gendata = userResourcesServiceIfc.findByInsertedDateBetween(from, to);
		List<ChartData> chartdata = new ArrayList<ChartData>();
		Map <String, BigDecimal> map = new HashMap<String ,BigDecimal>();
		for (PowerGenData powerGenData : gendata) {
			
			if(!map.containsKey(powerGenData.getSite())){
				map.put(powerGenData.getSite(), powerGenData.getVoltage());
			}else{
				BigDecimal bd = map.get(powerGenData.getSite());
				bd = bd.add(powerGenData.getVoltage());
				map.put(powerGenData.getSite(), bd);
			}
		}
		Set<String> keySet  = map.keySet();
		for (String string : keySet) {
			ChartData chart = new ChartData();
			chart.setSiteName(string);
			chart.setVoltageSum(map.get(string));
			chartdata.add(chart);
		}
		
		return chartdata; 
	}
}
