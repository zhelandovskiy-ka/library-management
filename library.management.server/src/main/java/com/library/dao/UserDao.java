package com.library.dao;

import java.util.List;

import com.library.entity.User;

public interface UserDao {
	User getById(Long id);

	User create(User user);

	User update(User user);
	
	boolean delete(Long id);

	List<User> getAll();
}
