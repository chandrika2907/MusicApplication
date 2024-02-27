package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entities.Song;
import com.example.demo.service.Songservice;



@Controller
public class SongsController {
	@Autowired
	Songservice serv;
	@PostMapping("addsongs")
	public String addSongs(@ModelAttribute Song song) {
		 Boolean bb= serv.songExists(song.getName());
		if(bb==false) {
		serv.addSongs(song);
		return "songsuccess";
		
	}
		else {
			return"songfail";
		}
	
}
	@GetMapping("view-songs")
	public String viewSongs(Model model) {
	
		List<Song> songs=serv.viewSongs();
		model.addAttribute("songs",songs);
		
		return "displaysongs";
		
		
	}
	@GetMapping("customer-songs")
	public String viewCustomerSongs(Model model) {
		
		Boolean primeStatus=true;
		if(primeStatus==true) {
			
			List<Song> songs=serv.viewSongs();
			model.addAttribute("songs",songs);
			return "displaysongs";
		}
		else {
			return "makePayment";
		}

		
		
	}
}
