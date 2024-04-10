package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UsersService 
{
	public String addUser(Users user);

	public boolean emailExits(String email);

	public boolean ValidateUser(String email, String password);

	public String getrole( String email);

	
	
}
