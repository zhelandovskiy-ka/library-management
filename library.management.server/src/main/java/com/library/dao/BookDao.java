package com.library.dao;

import java.util.List;

import com.library.entity.Book;

public interface BookDao {
	Book getById(Long id);

	Book create(Book book);

	Book update(Book book);
	
	boolean delete(Long id);

	List<Book> getAll();
}
