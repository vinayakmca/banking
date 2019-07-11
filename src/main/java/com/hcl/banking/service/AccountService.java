package com.hcl.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.dto.StatmentDto;
import com.hcl.banking.entity.Account;
import com.hcl.banking.entity.User;
import com.hcl.banking.repository.AccountRepository;
import com.hcl.banking.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void addAccount(User user) {
		 Account objAccount=new Account();
		 int number=(int)((Math.random()*9000000)+1000000);
		 objAccount.setAccountNo(String.valueOf(number));
		 objAccount.setUser(user);
		 objAccount.setBalance(10000);
		 accountRepository.save(objAccount);
	}
	
	public List<StatmentDto> getLatestTransaction(Long id){
		return accountRepository.findLastTransaction(id);
	}
	
}
