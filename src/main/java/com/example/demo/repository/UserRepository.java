package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByEmailid(String emailid);
	

}
