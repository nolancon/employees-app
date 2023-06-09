package com.bank.accounts.repositories;

import com.bank.accounts.details.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long>
{
	
}
