package edu.ndsi.microservices.service;

import java.util.List;

import edu.ndsi.microservices.model.User;

public interface UserService {

//	User save(User user);

	List<User> findAll();

//	void delete(long id);
}