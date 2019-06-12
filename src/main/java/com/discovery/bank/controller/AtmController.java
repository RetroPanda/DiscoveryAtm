package com.discovery.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.discovery.bank.dto.ClientAccount;
import com.discovery.bank.exception.RemainderException;
import com.discovery.bank.model.ClientAccountModel;
import com.discovery.bank.model.DenominationModel;
import com.discovery.bank.repo.AccountRepository;
import com.discovery.bank.service.AtmService;

@Controller
public class AtmController {
	
	@Autowired
	AtmService atmService;

	@RequestMapping("/accounts/transactional")
    public String getTransactionalAccounts(@RequestParam int id, Model model) { 	
		List<ClientAccountModel> accounts = atmService.getTransactionalAccountsByClientId(id);
		model.addAttribute("accounts", accounts);
		 return "transactional";
    }
	
	@RequestMapping("/accounts/currency")
    public String getCurrencyAccounts(@RequestParam int id, Model model) { 	

		List<ClientAccountModel> accounts = atmService.getCurrencyAccountsByClientId(id);
		model.addAttribute("accounts", accounts);
		 return "currency";
    }

}
