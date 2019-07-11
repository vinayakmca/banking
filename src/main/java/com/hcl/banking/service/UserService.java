package com.hcl.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.entity.User;
import com.hcl.banking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
	  return userRepository.save(user);
	}
	
	public User checkUserExist(String userName,String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User  getUserById(Long id) {
		Optional<User> optionalUser=userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null; 
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public List<User> getUserByName(String name){
		return userRepository.findByFirstName(name);
	}
	
	public void updateUser(User user,Long id) {
		User objUser=getUserById(id);
		objUser.setEmail(user.getEmail()==null? objUser.getEmail() : user.getEmail() );
		objUser.setFirstName(user.getFirstName()==null ? objUser.getFirstName() : user.getFirstName());
		objUser.setLastName(user.getLastName()==null ? objUser.getLastName() : user.getLastName());
		userRepository.save(objUser);
		
	}
}
