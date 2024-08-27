package com.library.service;

import java.util.List;

import com.library.entity.Book;

public interface BookService {
	Book create(Book book);

	Book update(Book book);
	
	boolean delete(Long id);
	
	List<Book> getAll();
	
	String test();
}
