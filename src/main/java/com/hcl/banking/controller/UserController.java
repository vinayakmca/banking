package com.hcl.banking.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
  /**
   * This API for create user
 * @param user
 * @return it display message
 */
@PostMapping("")
  public ResponseEntity<String> saveUser(@RequestBody User user){
	 User objUser= userService.saveUser(user);
	 accountService.addAccount(objUser);
	  return new ResponseEntity<String>("User created",HttpStatus.OK); 
  }
  
  /**
   * This API for login user purpose
 * @param requestBody which consist userName and password
 * @return 10 latest tranjactions
 */
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
  
  /**
   * This API returns all user data
 * @return all users data 
 */
@GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers(){
	  return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
  }
  
  /**
   * This API find user by first name
 * @param name :  this parameter used for search by name
 * @return return user list
 */
@GetMapping("/find")
  public ResponseEntity<List<User>> getUserByName(@RequestParam("name") String name){
	  return new ResponseEntity<List<User>>(userService.getUserByName(name),HttpStatus.OK);
  }
  
  /**
   * This API used for return User by id
 * @param id : user id 
 * @return returns user by id
 */
@GetMapping("/{id}")
  public ResponseEntity<User> getUserById( @ApiParam(value = "User Id to search user object", required = true)@PathVariable Long id){
	  return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
  }
  
  /**
   * This API update user entity
 * @param id : user id
 * @param user : user request body
 * @return  it return message
 */
@PutMapping("/{id}")
  public ResponseEntity<String> updateUserById(@PathVariable Long id,@RequestBody User user){
	  userService.updateUser(user, id);
	  return new ResponseEntity<String>("User updated",HttpStatus.OK);
  }
  
  /**
   * This API used for delete user by id
 * @param id : user id
 * @return it return message
 */
@DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUserById(@PathVariable Long id){
	  userService.deleteUser(id);
	  return new ResponseEntity<String>("User deleted",HttpStatus.OK);
  }

}
