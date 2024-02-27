package com.example.demo.service;

import java.util.List;

import com.example.demo.Entities.PlayList;

public interface PlayListInterface {
	
	public void addPlayList(PlayList playlist);
	public List<PlayList> fetchPlaylist();

}
