package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.PlayList;
import com.example.demo.repository.PlayListRepository;

@Service
public class PlayListService  implements PlayListInterface{
	@Autowired
	PlayListRepository plre;

	@Override
	public void addPlayList(PlayList playlist) {
		plre.save(playlist);
		
	}

	@Override
	public List<PlayList> fetchPlaylist() {
		
		
		return	plre.findAll();
	}
}
