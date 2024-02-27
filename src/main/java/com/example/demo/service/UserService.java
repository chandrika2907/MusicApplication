package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserService implements ServiceImplementation {

	@Autowired
	UserRepository repo;
	@Override
	public String addUser(User user) {
		repo.save(user);
		return "object is created and saved";
	}
	@Override
	public boolean emailExist(String emailid) {
		
		if(repo.findByEmailid(emailid)==null) {
			return false;
		}
		else {
			return true;
		}
	
	
	
	
	}
	@Override
	public boolean validateUser(String emailid, String password) {
		User user=repo.findByEmailid(emailid);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public String getRole(String emailid) {
		return(repo.findByEmailid(emailid).getRole());
	
	}
	@Override
	public User getUser(String email) {
		return repo.findByEmailid(email);
	}

	public void updateUser(User user) {
       repo.save(user);		
	}
	
		
}
