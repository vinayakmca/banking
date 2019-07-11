package com.hcl.banking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.entity.Account;
import com.hcl.banking.entity.Transcation;
import com.hcl.banking.repository.AccountRepository;
import com.hcl.banking.repository.TranscationRepository;

@Service
public class TranscationService {

	@Autowired
	TranscationRepository transcationRepository;
	
	@Autowired
	AccountRepository   accountRepository;
	
	public void saveTranjaction(String fromAccount,String toAccount,String amount,String transcationType ) {
		Account objFromAccount=accountRepository.findByUserId(Long.parseLong(fromAccount));
		Account objToAccount=accountRepository.findByUserId(Long.parseLong(toAccount));
	    Transcation objTranscation=new Transcation();
	
	   objTranscation.setTranscationType(transcationType);
	    objTranscation.setAmount(Integer.parseInt(amount));
	    objTranscation.setTranscationDate(new Date());
	    objTranscation.setFromAccount(objFromAccount);
  	    objTranscation.setToAccount(objToAccount);
  	  
	    if(transcationType.equals("debit")) {
	    	  
	    	objFromAccount.setBalance(objFromAccount.getBalance()-Integer.parseInt(amount));
	    	accountRepository.save(objFromAccount);
	    	
	    }
	    if(transcationType.equals("credit")) {
	  	  objFromAccount.setBalance(objFromAccount.getBalance()+Integer.parseInt(amount));
	    	accountRepository.save(objToAccount);
	    }
	    transcationRepository.save(objTranscation);
	}
}
