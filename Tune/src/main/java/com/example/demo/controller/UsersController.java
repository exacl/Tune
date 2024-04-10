package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

@Controller
public class UsersController 
{
	@Autowired
	UsersService service;
	@PostMapping("/register")
	
	public String addUsers(@ModelAttribute Users user) 
	{
		boolean userStatus=service.emailExits(user.getEmail());
		if(userStatus==false) {
			service.addUser(user);
			System.out.println("user added");
		}
		else {
			System.out.println("user already exists");
		}
	
				return "home";
	}
	@PostMapping("/Validate")
	public String Validate(@RequestParam ("email")String email,@RequestParam("password")String password) 
	{
		if(service.ValidateUser(email,password)==true) 
		{
			String role=service.getrole(email);
				if(role.equals("admin")) {
					return "admin";
				}
				else {
					return "customer";
				}
			
		
	
	}
	else 
	{
		return "login";
		
	}
}
}
