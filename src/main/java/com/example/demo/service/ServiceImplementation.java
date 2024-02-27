package com.example.demo.service;

import com.example.demo.Entities.Song;
import com.example.demo.Entities.User;

public interface ServiceImplementation {
	public String addUser(User user);
	public boolean emailExist(String emailid);
	public boolean validateUser(String emailid,String password);
    public String getRole(String emailid);
    public User getUser(String email);
    
  
   
}
