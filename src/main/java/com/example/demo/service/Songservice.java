package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Song;
import com.example.demo.repository.SongRepository;

@Service
public class Songservice implements SongserviceInterface {
    @Autowired
	SongRepository repo;

	

	@Override
	public String addSongs(Song song) {
		repo.save(song);
		return "songs are added";
	}



	@Override
	public Boolean songExists(String name) {
		Song song=repo.findByName(name);
		if(song==null) {
			
		return false;
	}
		else {
			return true;
		}

}
	public List<Song> viewSongs() {
	List<Song> songs=repo.findAll();
		return songs;
		
		
	}
	@Override
	public List<Song> fetchallSongs() {
		List<Song>songslist=repo.findAll();
		return songslist;
	
	}


	public void updateSong(Song song) {
		repo.save(song);
	}





}


