package com.hcl.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.banking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByFirstName(String firstName);
	
	public User findByUserNameAndPassword(String userName,String password);
}
