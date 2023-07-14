package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
	@Query("select u from User u where mail = ?1 and password = ?2")
	public User getUserDetails(String mail, String password);
}
