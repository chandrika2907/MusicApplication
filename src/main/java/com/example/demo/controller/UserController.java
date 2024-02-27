package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entities.Song;
import com.example.demo.Entities.User;
import com.example.demo.service.Songservice;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService uservice;
	@Autowired
	Songservice s;
	
@PostMapping("/Register")
	public String addUser(@ModelAttribute User user) 
	{
	   Boolean b=uservice.emailExist(user.getEmailid());
			   {
		  if(b==false)
		  {
				uservice.addUser(user);
			return "registersuccess";
		  }
		  else {
			return "registerFail";
			  
			  
		  }
		
	}
		
	}
@PostMapping("/login")
	public String validateUser(@RequestParam String emailid, @RequestParam String password,HttpSession session) {
	
		if(uservice.validateUser(emailid,password)==true)
		{
			session.setAttribute("emailid", emailid);
			
			if(uservice.getRole(emailid).equals("Admin")) {
				
				return "adminhome";
			}
			else {
				return "customerhome";
			}
		}
		else {
			return "loginfail";
		}
		
		
	}
@GetMapping("explore-songs")
public String exploreSongs(HttpSession session,Model model) {
	String emailid=(String)session.getAttribute("emailid");
		
		User user=uservice.getUser(emailid);
		Boolean status=user.isPremium();
	
		if ( status == true) {
		    // Your code here
		List<Song> songs = s.fetchallSongs();
			model.addAttribute("songs", songs);
		
			return "displaysongs";
		}
		else  
		{
			return "payment";
		}
		
	}

	

}
