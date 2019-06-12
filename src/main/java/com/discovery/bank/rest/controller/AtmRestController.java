package com.discovery.bank.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.discovery.bank.exception.RemainderException;
import com.discovery.bank.model.DenominationModel;
import com.discovery.bank.service.AtmService;

@RestController
public class AtmRestController {
	
	@Autowired
	AtmService atmService;
	
	@RequestMapping("/withdraw")
    public List<DenominationModel> withdraw(@RequestParam String accNumber,@RequestParam int amount,@RequestParam int atmId,Model model) throws RemainderException { 
		return atmService.withdraw(accNumber, amount, atmId);
    }
}
