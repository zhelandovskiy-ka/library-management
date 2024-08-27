package com.library.service;

import java.util.List;

import com.library.entity.User;

public interface UserService {
	User getById(Long id);

	User create(User user);

	User update(User user);
	
	boolean delete(Long id);

	List<User> getAll();
}
