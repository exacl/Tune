package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServiceImplementation 
           implements UsersService
           {
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {

         repo.save(user);
         
		return "users added successfully";
	}

	@Override
	public boolean emailExits(String email) {
		if(repo.findByEmail(email)==null) {
		return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean ValidateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass)){
		return true;
	}
		else {
			return false;
		}
	}

	@Override
	public String getrole(String email) {
		Users user = repo.findByEmail(email);
		return user.getRole();
	}
  }
           


