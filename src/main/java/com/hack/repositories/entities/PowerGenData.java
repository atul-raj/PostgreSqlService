package com.hack.repositories.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "powergen_data")
public class PowerGenData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "turbine")
	private String turbine;

	@Column(name = "site")
	private String site;

	@Column(name = "customer")
	private String customer;

	@Column(name = "project")
	private String project;

	@Column(name = "status")
	private boolean status;

	@Column(name = "temperature", precision=5, scale=2)
	private BigDecimal temperature;

	@Column(name = "voltage",  precision=5, scale=2)
	private BigDecimal voltage;

	@Column(name = "inserted_date", columnDefinition = "timestamp DEFAULT current_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedDate;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getVoltage() {
		return voltage;
	}

	public void setVoltage(BigDecimal voltage) {
		this.voltage = voltage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		if (insertedDate == null)
			insertedDate = new Date();
		this.insertedDate = insertedDate;
	}

	public String getTurbine() {
		return turbine;
	}

	public void setTurbine(String turbine) {
		this.turbine = turbine;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
}
