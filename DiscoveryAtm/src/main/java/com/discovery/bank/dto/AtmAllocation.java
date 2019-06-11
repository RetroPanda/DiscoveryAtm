package com.discovery.bank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtmAllocation {
	@Id
	@Column(name = "ATM_ALLOCATION_ID ")
	private int atmAllocationId;

	@Column(name = "ATM_ID")
	private int atmId;

	@Column(name = "DENOMINATION_ID ")
	private int denominationId;
	
	@Column(name = "COUNT ")
	private int count;

	public int getAtmAllocationId() {
		return atmAllocationId;
	}

	public void setAtmAllocationId(int atmAllocationId) {
		this.atmAllocationId = atmAllocationId;
	}

	public int getAtmId() {
		return atmId;
	}

	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}

	public int getDenominationId() {
		return denominationId;
	}

	public void setDenominationId(int denominationId) {
		this.denominationId = denominationId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
