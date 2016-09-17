package com.hack.controllers;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hack.repositories.UserResourcesServiceIfc;
import com.hack.repositories.entities.ChartData;
import com.hack.repositories.entities.PowerGenData;
import com.hack.services.UserResourcesService;
import com.hack.util.CustomSortingUtil;

@RestController
@RequestMapping("/api/v1/pgd")
public class UserResourcesCtrl {

	@Autowired
	UserResourcesServiceIfc userResourcesServiceIfc;

	@Autowired
	UserResourcesService userResourcesService;

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String getHello() {
		return "String hello world from the service";
	}

	@RequestMapping(name = "/", method = RequestMethod.POST)
	public PowerGenData createResource(@RequestBody PowerGenData input) {
		if (input.getInsertedDate() == null) {
			input.setInsertedDate(new Date());
		}
		return userResourcesServiceIfc.saveAndFlush(input);
	}

	@RequestMapping("/all")
	public List<PowerGenData> getPowerData() {
		return userResourcesServiceIfc.findAll();
	}

	@RequestMapping("/id/{id}")
	public PowerGenData getResourcesById(@PathVariable Long id) {
		return userResourcesServiceIfc.findOne(id);
	}

	@RequestMapping("/turbine/{turbine}")
	public List<PowerGenData> getTurbineData(@PathVariable String turbine) {
		return userResourcesService.findByTurbine(turbine);
	}

	@RequestMapping("/site/{site}")
	public List<PowerGenData> findBySite(String site) {
		return userResourcesService.findBySite(site);
	}

	@RequestMapping("/tem/{lower}/{upper}/date/{from}/{to}")
	public List<PowerGenData> findByTemperatureBetweenAndInsertedTimeDateBetween(@PathVariable BigDecimal lower,
			@PathVariable BigDecimal upper, @PathVariable Date from, @PathVariable Date to) {
		return userResourcesService.findByTemperatureBetweenAndInsertedTimeDateBetween(lower, upper, from, to);
	}

	@RequestMapping("/vol/{lower}/{upper}/date/{from}/{to}")
	public List<PowerGenData> findByVoltageBetweenAndInsertedTimeDateBetween(@PathVariable BigDecimal lower,
			@PathVariable BigDecimal upper, @PathVariable Date from, @PathVariable Date to) {
		return userResourcesService.findByVoltageBetweenAndInsertedTimeDateBetween(lower, upper, from, to);
	}

	@RequestMapping("/date/{from}/{to}")
	public List<PowerGenData> findByInsertedTimeDateBetween(@PathVariable Date from, @PathVariable Date to) {
		return userResourcesService.findByInsertedTimeDateBetween(from, to);
	}

	@RequestMapping("/date/current/")
	public List<PowerGenData> findCurrentTimeDateBetween() {
		Date from;
		Date to = new Date();
		from = new Date(new Date().getTime() - (1000 * 60 * 10));
		return userResourcesService.findByInsertedTimeDateBetween(from, to);
	}
	@RequestMapping("/date/chart")
	public List<ChartData> getChartData() {
		Date from;
		Date to = new Date();
		from = new Date(new Date().getTime() - (1000 * 60 * 10));
		List<ChartData> chartData = userResourcesService.getChartData(from, to);
		Collections.sort(chartData, CustomSortingUtil.siteByAscending);
		return chartData;
	}

	@RequestMapping(name = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long id) {
		userResourcesServiceIfc.delete(id);
	}

	@RequestMapping("/date/current/site/{site}")
	public List<PowerGenData> getSiteData(@PathVariable String site) {
		Date from;
		Date to = new Date();
		from = new Date(new Date().getTime() - (1000 * 60 * 10));
		return userResourcesService.getSiteData(site, from, to);
	}


	@RequestMapping("/site/{site}/turbine/{turbine}")
	public List<PowerGenData> getAllTurbineData(@PathVariable String site, @PathVariable String turbine) {
		Date from;
		Date to = new Date();
		from = new Date(new Date().getTime() - (1000 * 60 * 60 * 8));

		return userResourcesService.getTurbineData(site, turbine, from, to);
	}
}
