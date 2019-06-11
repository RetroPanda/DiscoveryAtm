package com.discovery.bank.repo;

import org.springframework.data.repository.CrudRepository;

import com.discovery.bank.dto.AccountType;

public interface AccountTypeRepository extends CrudRepository<AccountType, String> {
}
