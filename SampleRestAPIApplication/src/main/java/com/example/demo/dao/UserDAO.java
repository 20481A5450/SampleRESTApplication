package com.example.demo.dao;

import com.example.demo.model.User;

public interface UserDAO 
{
	public String userSaving(User user);
	public User checkUserLogin(String email, String password);
}
