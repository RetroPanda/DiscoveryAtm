package com.discovery.bank.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.discovery.bank.dto.AtmAllocation;

public interface AtmAllocationRepository extends CrudRepository<AtmAllocation, Integer> {

	List<AtmAllocation> findByAtmId(int atmId);

	Optional<AtmAllocation> findByAtmIdAndDenominationId(int atmId, int id);
	
}
