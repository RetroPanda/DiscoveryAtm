package com.discovery.bank.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyConversionRate {
	@Id
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name = "CONVERSION_INDICATOR")
	private String conversionIndicator;
	
	@Column(name = "RATE")
	private BigDecimal rate;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getConversionIndicator() {
		return conversionIndicator;
	}
	public void setConversionIndicator(String conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
}
