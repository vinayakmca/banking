package com.hcl.banking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.banking.service.TranscationService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	TranscationService transcationService;
 
	/**
	 * This API used for fund transfer
	 * @param requestBody : it consist field fromAccount,toAccount ,amount
	 * @return it return message
	 */
	@PostMapping("/transcation")
	 public ResponseEntity<String> saveUser(@RequestBody Map<String,String> requestBody){
		   transcationService.saveTranjaction(requestBody.get("fromAccount"),requestBody.get("toAccount"), requestBody.get("amount"), "debit");
		   transcationService.saveTranjaction(requestBody.get("toAccount"),requestBody.get("fromAccount"), requestBody.get("amount"), "credit");
		  return new ResponseEntity<String>("transaction completed",HttpStatus.OK); 
	  }

}
