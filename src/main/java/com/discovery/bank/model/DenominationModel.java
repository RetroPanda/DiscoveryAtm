package com.discovery.bank.model;

public class DenominationModel {
	private int denominationId;
	private int denominationValue;
	private int numberOfNotesToDispense;
	private int numberOfNotesLeft;
	
	public int getNumberOfNotesLeft() {
		return numberOfNotesLeft;
	}
	public void setNumberOfNotesLeft(int numberOfNotesLeft) {
		this.numberOfNotesLeft = numberOfNotesLeft;
	}
	public int getDenominationValue() {
		return denominationValue;
	}
	public void setDenominationValue(int denominationValue) {
		this.denominationValue = denominationValue;
	}
	
	public int getDenominationId() {
		return denominationId;
	}
	public void setDenominationId(int denominationId) {
		this.denominationId = denominationId;
	}
	public int getNumberOfNotesToDispense() {
		return numberOfNotesToDispense;
	}
	public void setNumberOfNotesToDispense(int numberOfNotesToDispense) {
		this.numberOfNotesToDispense = numberOfNotesToDispense;
	}
	
}
