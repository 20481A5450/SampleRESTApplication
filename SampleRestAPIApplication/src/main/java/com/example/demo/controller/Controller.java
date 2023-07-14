package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

@RestController
public class Controller 
{
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping("/userSignup")
	public String saveUser(@RequestBody User user)
	{
		return userDAO.userSaving(user);
	}
	
	@PostMapping("/userLogin")
	public String checkUserDetails(@RequestBody User user)
	{
		User user2 = userDAO.checkUserLogin(user.getMail(), user.getPassword());
		if(user2 != null)
		{
			return "Hello from GreenStitch";
		}
		else
		{
			return "Please provide valid credentials";
		}
	}
}
