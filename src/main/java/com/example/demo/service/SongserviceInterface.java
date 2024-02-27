package com.example.demo.service;

import java.util.List;

import com.example.demo.Entities.Song;

public interface SongserviceInterface {
	public String addSongs(Song song);
	public Boolean songExists(String name);
	public List<Song> fetchallSongs();
	public void updateSong(Song song);
	

}
