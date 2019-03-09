package edu.ndsi.microservices.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ndsi.microservices.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
}