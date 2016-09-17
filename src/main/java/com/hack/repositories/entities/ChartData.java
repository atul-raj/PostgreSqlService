package com.hack.repositories.entities;

import java.math.BigDecimal;

public class ChartData {

	private String siteName;

	private BigDecimal voltageSum;

	public BigDecimal getVoltageSum() {
		return voltageSum;
	}

	public void setVoltageSum(BigDecimal voltageSum) {
		this.voltageSum = voltageSum;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

}
