package com.example.demo.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class PlayList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<Song>songslist;
	public PlayList() {
		super();
	}
	public PlayList(int id, String name, List<Song> songslist) 
    {
		super();
		this.id = id;
		this.name = name;
		this.songslist = songslist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getSongslist() {
		return songslist;
	}
	public void setSongslist(List<Song> songslist) {
		this.songslist = songslist;
	}
	
	@Override
	public String toString() {
		return "PlayList [id=" + id + ", name=" + name + ", songslist=" + songslist + "]";
	}

}
