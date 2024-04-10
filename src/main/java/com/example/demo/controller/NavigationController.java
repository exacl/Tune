package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavigationController
{
	@GetMapping("/login")
	public String login() {
		return  "login";
	}
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@GetMapping("/newsong")
	public String newsong() {
		return "newsong";
	}

}
