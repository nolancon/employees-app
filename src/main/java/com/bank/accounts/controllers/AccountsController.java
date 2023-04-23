package com.bank.accounts.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accounts.details.Account;
import com.bank.accounts.exceptions.ResourceNotFoundException;
import com.bank.accounts.repositories.AccountsRepository;


@RestController
public class AccountsController {	
	Logger log = LoggerFactory.getLogger(AccountsController.class);
	
	@Autowired
	Version version;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	
	@GetMapping("/accounts/version")
    public Version getVersion() {
		return new Version(version.getVersion());
    }
	
	@GetMapping("/accounts")
    public List<Account> getAccounts() {
		log.info("getAccounts called");

        return accountsRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity< Account > getAccountById(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
		log.info("getAccountById called");

    	Optional<Account> account = accountsRepository.findById(accountId);
        if(account.isPresent())
            return ResponseEntity.ok().body(account.get());
        else
            throw new ResourceNotFoundException("Account not found :: " + accountId);
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
    	log.info("createAccounts called");
        return accountsRepository.save(account);
    }
    
    

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable(value = "id") Long accountId){
    	log.info("deleteAccount called");
        accountsRepository.deleteById(accountId);
    }
}