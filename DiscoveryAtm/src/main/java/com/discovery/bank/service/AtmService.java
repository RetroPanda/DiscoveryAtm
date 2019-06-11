package com.discovery.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discovery.bank.dto.AccountType;
import com.discovery.bank.dto.AtmAllocation;
import com.discovery.bank.dto.ClientAccount;
import com.discovery.bank.dto.Currency;
import com.discovery.bank.dto.CurrencyConversionRate;
import com.discovery.bank.dto.Denomination;
import com.discovery.bank.model.ClientAccountModel;
import com.discovery.bank.model.DenominationModel;
import com.discovery.bank.repo.AccountRepository;
import com.discovery.bank.repo.AccountTypeRepository;
import com.discovery.bank.repo.AtmAllocationRepository;
import com.discovery.bank.repo.ConversionRateRepository;
import com.discovery.bank.repo.CurrencyRepository;
import com.discovery.bank.repo.DenominationRepository;

@Service
public class AtmService {
	@Autowired
	AccountRepository accRepository;
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	ConversionRateRepository conversionRateRepository;
	
	@Autowired
	AccountTypeRepository accTypeRepository;
	
	@Autowired
	AtmAllocationRepository atmAllocationRepository;
	
	@Autowired
	DenominationRepository denominationRepository;
	
	public List<DenominationModel> withdraw(String accNumber, int amount, int atmId) {
		ClientAccount account = accRepository.findByClientAccountNumber(accNumber).get();
	
		BigDecimal balance = account.getDisplayBalance();
		if(balance.subtract(BigDecimal.valueOf(amount)).intValue() < 0){
//			throw new InsufficentFundsError();
		}
		Double nextLowest=0.00;
		if(amount % 10 == 0){
			nextLowest=Math.floor(amount);
		}else {
//			throw new InsufficentNotesError(nextLowest);
		}
		List<AtmAllocation> atms = new ArrayList<>();
		atmAllocationRepository.findByAtmId(atmId).forEach((atm) -> atms.add(atm));
		
		//get denominationsIds in order
		ArrayList<Integer> notes = new ArrayList<Integer>();
		notes.add(200);
		notes.add(100);
		notes.add(50);
		notes.add(20);
		notes.add(10);
		ArrayList<Integer> denominationIds = new ArrayList<Integer>();
		for(int i = 0;i<notes.size();i++) {
			denominationIds.add(denominationRepository.findByValue(BigDecimal.valueOf(notes.get(i))).get().getDenominationId());
		}
		ArrayList<Integer> counts = new ArrayList<Integer>();
		for(int i = 0;i<denominationIds.size();i++) {
			counts.add(calculateCountForDenomination(atmId, denominationIds.get(i)));
		}
		int requested = amount;
		for(int i = 0;i<notes.size();i++) {
			int wholeNumber = (int) Math.floor(requested/notes.get(i));
			if(wholeNumber<counts.get(i)) {
				counts.add(i+1, counts.get(i) - wholeNumber);
				counts.remove(i);
				requested=requested-wholeNumber*notes.get(i);
			}else {
				requested=requested-counts.get(i)*notes.get(i);
				counts.add(i+1,0);
				counts.remove(i);
			}
			if(requested!=0) {
			//	throw new RemainderException("Can only withdraw " + (amount-requested));
				break;
			}
		}
			
		//Adjust account balance
		account.setDisplayBalance(account.getDisplayBalance().subtract(BigDecimal.valueOf(amount)));
		//accRepository.save(account);
		List<DenominationModel> denominations = new ArrayList<>();
		for(int i = 0;i<counts.size();i++) {
			DenominationModel denomination = new DenominationModel();
			denomination.setCount(counts.get(i));
			denomination.setId(denominationIds.get(i));
			denominations.add(denomination);
		}
		
		//Deduct notes dispensed from ATM count
		for(DenominationModel denomiation : denominations) {	
			AtmAllocation atm = atmAllocationRepository.findByAtmIdAndDenominationId(atmId, denomiation.getId()).get();
			atm.setCount(atm.getCount()-denomiation.getCount());
			//atmAllocationRepository.save(atm);
		}
		
		return denominations;
	}

	public List<ClientAccountModel> getCurrencyAccountsByClientId(int id) {
		List<ClientAccount> accounts = new ArrayList<ClientAccount>();
		List<ClientAccountModel> accountsToReturn = new ArrayList<ClientAccountModel>();
		accRepository.findByClientId(id).forEach((account) -> accounts.add(account));
		
		for(ClientAccount account : accounts) {
			ClientAccountModel clientAccountModel = new ClientAccountModel();
			Currency curr = currencyRepository.findById(account.getCurrencyCode()).get();
			CurrencyConversionRate conversionRate = conversionRateRepository.findById(account.getCurrencyCode()).get();
			clientAccountModel.setAccountNumber(account.getClientAccountNumber());
			clientAccountModel.setAccountBalance(account.getDisplayBalance().doubleValue());
			clientAccountModel.setCurrency(account.getCurrencyCode());
			clientAccountModel.setConversionRate(conversionRate.getRate());
			clientAccountModel.setAccountConvertedBalance(convert(account.getDisplayBalance(), conversionRate.getRate(), curr.getDecimalPlaces(), conversionRate.getConversionIndicator()).doubleValue());
			accountsToReturn.add(clientAccountModel);
		}
		accountsToReturn.sort(new Comparator<ClientAccountModel>() {
            @Override
            public int compare(ClientAccountModel account1, ClientAccountModel account2) {
            	return account1.getAccountBalance().compareTo(account2.getAccountBalance());
             }
        });
		return accountsToReturn;
	}
	
	public List<ClientAccountModel> getTransactionalAccountsByClientId(int id) {
		
		List<ClientAccount> accounts = new ArrayList<ClientAccount>();
		List<ClientAccountModel> accountsToReturn = new ArrayList<ClientAccountModel>();
		accRepository.findByClientId(id).forEach((account) -> accounts.add(account));
		
		for(ClientAccount account : accounts) {
			ClientAccountModel clientAccountModel = new ClientAccountModel();
			AccountType accType = accTypeRepository.findById(account.getAccountTypeCode()).get();
			clientAccountModel.setAccountNumber(account.getClientAccountNumber());
			clientAccountModel.setAccountBalance(account.getDisplayBalance().doubleValue());
			clientAccountModel.setAccountType(accType.getDesciption());
			accountsToReturn.add(clientAccountModel);
		}
		accountsToReturn.sort(new Comparator<ClientAccountModel>() {
            @Override
            public int compare(ClientAccountModel account1, ClientAccountModel account2) {
            	return account1.getAccountBalance().compareTo(account2.getAccountBalance());
             }
        });
		return accountsToReturn;
	}
	
	private BigDecimal convert(BigDecimal amount, BigDecimal conversionRate, int decimalPlaces, String indicator) {
		String str = indicator.trim();
		BigDecimal converted = null;
		if(str.equals("*")){
			converted = amount.multiply(conversionRate);
		} else if(str.equals("/")){
			converted = amount.divide(conversionRate, RoundingMode.HALF_UP);
		}
		return converted;
	}
	
	private int calculateCountForDenomination(int atmId, int denominationId) {
		AtmAllocation atm = atmAllocationRepository.findByAtmIdAndDenominationId(atmId, denominationId).get();
		return atm.getCount();
	}
}