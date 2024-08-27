package com.library.service.impl;

import java.util.List;

import jakarta.inject.Inject;
import com.library.dao.UserDao;
import com.library.entity.User;
import com.library.service.UserService;

public class UserServiceImpl implements UserService {
	private final UserDao userDao;

	@Inject
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean delete(Long id) {
		return userDao.delete(id);
	}

	@Override
	public User getById(Long id) {
		return userDao.getById(id);
	}
}