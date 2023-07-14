package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String userSaving(User user) 
	{
		String s = "";
		try
		{
			userRepository.save(user);
			s = "User signup successfull !";
		}
		catch (DataIntegrityViolationException e) {
			s = "A user already exists with same mobile/email/verification proof";
		}
		return s;
	}

	@Override
	public User checkUserLogin(String email, String password) 
	{
		User user = userRepository.getUserDetails(email, password);
		return user;
	}
	
}
