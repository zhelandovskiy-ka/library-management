package com.library.service.impl;

import java.util.List;

import jakarta.inject.Inject;
import com.library.dao.BookDao;
import com.library.entity.Book;
import com.library.service.BookService;

public class BookServiceImpl implements BookService {
	private final BookDao bookDao;

	@Inject
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Book create(Book book) {
		return bookDao.create(book);
	}

	@Override
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	@Override
	public Book update(Book book) {
		return bookDao.update(book);
	}

	@Override
	public boolean delete(Long id) {
		return bookDao.delete(id);
	}
}
