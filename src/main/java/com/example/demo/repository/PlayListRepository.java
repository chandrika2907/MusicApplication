package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList,Integer> {
	
	

}
