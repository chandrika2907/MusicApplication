package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entities.PlayList;
import com.example.demo.Entities.Song;
import com.example.demo.service.PlayListService;
import com.example.demo.service.Songservice;



@Controller
public class PlayListController {
	
	@Autowired
	PlayListService pls;
	@Autowired
	Songservice srv;
	@GetMapping("play-list")
	public String createPlayList(Model model) {
		//fetching the songs by using song service
		List<Song> songslist=srv.viewSongs();
		//adding the songs in the model
		model.addAttribute("songslist",songslist);
		//sending to createpalylist
		return "createPlayList";
	}
	@PostMapping("add-playList")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		
		pls.addPlayList(playlist);
		 List<Song>songslist=playlist.getSongslist();
		//getting all the songs which are present inside the songs list and adding the songs to the playlist object
	
		 for(Song song :songslist) {
		 song.getPlaylist().add(playlist);
		 srv.updateSong(song);
		 }
		
		return "playlistsuccess";
		 
		
	}
	@GetMapping("viewPlaylist")
	public String viewPlaylist(Model model) {
		
		List<PlayList>playlist=pls.fetchPlaylist();
		model.addAttribute("playlist",playlist);
	
		return "viewPlaylist";
		
		
	}
	

}
