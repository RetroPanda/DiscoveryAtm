package com.discovery.bank.repo;

import org.springframework.data.repository.CrudRepository;

import com.discovery.bank.dto.CurrencyConversionRate;

public interface ConversionRateRepository extends CrudRepository<CurrencyConversionRate, String> {
}
