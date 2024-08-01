package com.demo.dao.interfaces;

import java.util.List;
import java.util.Optional;

import com.demo.entity.User;

public interface IUserDAO {
	
	List<User>findAll();
	Optional<User>findById(Integer id);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUser(User user);

}
