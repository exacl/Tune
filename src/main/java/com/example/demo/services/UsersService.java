package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UsersService {
	public String addUser(Users user);
	public boolean emailExists(String email);
	public String getRole(String email);
	
	public Users getUser(String email);
	public void updateUser(Users user);
	public boolean ValidateUser(String email, String password);
}
