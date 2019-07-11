package com.hcl.banking.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.entity.User;
import com.hcl.banking.service.AccountService;
import com.hcl.banking.service.UserService;

import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@Autowired
	AccountService accountService;
	
  @PostMapping("")
  public ResponseEntity<String> saveUser(@RequestBody User user){
	 User objUser= userService.saveUser(user);
	 accountService.addAccount(objUser);
	  return new ResponseEntity<String>("User created",HttpStatus.OK); 
  }
  
  @PostMapping("/login")
  public ResponseEntity<Object> userLogin(@RequestBody Map<String,String> requestBody){
	 User objUser= userService.checkUserExist(requestBody.get("userName"), requestBody.get("password"));
	 if(objUser!=null) {
		 return new ResponseEntity<>(accountService.getLatestTransaction(objUser.getId()),HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("wrong credentilas",HttpStatus.OK);
	 }
	 
  }
  
  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers(){
	  return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
  }
  
  @GetMapping("/find/{name}")
  public ResponseEntity<List<User>> getUserByName(@PathVariable String name){
	  return new ResponseEntity<List<User>>(userService.getUserByName(name),HttpStatus.OK);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById( @ApiParam(value = "User Id to search user object", required = true)@PathVariable Long id){
	  return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<String> updateUserById(@PathVariable Long id,@RequestBody User user,BindingResult bindingResult){
	  userService.updateUser(user, id);
	  return new ResponseEntity<String>("User updated",HttpStatus.OK);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUserById(@PathVariable Long id){
	  userService.deleteUser(id);
	  return new ResponseEntity<String>("User deleted",HttpStatus.OK);
  }

}
