package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class SongController 
{
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song  song) {
		boolean songStatus=service.songExits(song.getName());
		if(songStatus==false) {
			service.addSong(song);
			System.out.println("Song added");
		}
		else {
			System.out.println("Song already exists");
		}

				return "admin";

	}
	@GetMapping("/viewSongs")
	public String viewSongs(Model  Model) {
		
		List<Song>songsList=service.fetchAllSongs();
		Model.addAttribute("songs", songsList);
		
		return "DisplaySongs";
	}

	

}
