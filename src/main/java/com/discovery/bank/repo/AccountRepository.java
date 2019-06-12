package com.discovery.bank.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.discovery.bank.dto.ClientAccount;

public interface AccountRepository extends CrudRepository<ClientAccount, String> {
	List<ClientAccount> findByClientId(int id);
	List<ClientAccount> findByClientIdAndAccountTypeCode(int id, String code);

	Optional<ClientAccount> findByClientAccountNumber(String accNumber);
}
