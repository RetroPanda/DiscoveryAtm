package com.discovery.bank.repo;

import org.springframework.data.repository.CrudRepository;

import com.discovery.bank.dto.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, String> {
}
