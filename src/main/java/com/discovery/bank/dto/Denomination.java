package com.discovery.bank.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Denomination {
	@Id
	@Column(name = "DENOMINATION_ID ")
	private int denominationId;

	@Column(name = "VALUE")
	private BigDecimal value;
	
	@Column(name = "DENOMINATION_TYPE_CODE")
	private String denominationTypeCode;

	public int getDenominationId() {
		return denominationId;
	}

	public void setDenominationId(int denominationId) {
		this.denominationId = denominationId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getDenominationTypeCode() {
		return denominationTypeCode;
	}

	public void setDenominationTypeCode(String denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
	}

	
}
