package com.discovery.bank.repo;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.discovery.bank.dto.AtmAllocation;
import com.discovery.bank.dto.ClientAccount;
import com.discovery.bank.dto.Denomination;

public interface DenominationRepository extends CrudRepository<Denomination, Integer> {

	Optional<Denomination> findByValue(BigDecimal bigDecimal);
}
