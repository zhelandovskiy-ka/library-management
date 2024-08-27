package com.library.util;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.library.dao.BookDao;
import com.library.dao.BookTransactionDao;
import com.library.dao.UserDao;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookTransactionDaoImpl;
import com.library.dao.impl.UserDaoImpl;
import com.library.service.BookService;
import com.library.service.BookTransactionService;
import com.library.service.UserService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.BookTransactionServiceImpl;
import com.library.service.impl.UserServiceImpl;

public class BookModule extends AbstractBinder {
	@Override
	protected void configure() {
		bind(BookServiceImpl.class).to(BookService.class);
		bind(BookDaoImpl.class).to(BookDao.class);
		
		bind(UserDaoImpl.class).to(UserDao.class);
		bind(UserServiceImpl.class).to(UserService.class);
		
		bind(BookTransactionDaoImpl.class).to(BookTransactionDao.class);
		bind(BookTransactionServiceImpl.class).to(BookTransactionService.class);
	}
}