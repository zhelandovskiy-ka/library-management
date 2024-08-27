package com.library.service;

import java.util.List;

import com.library.entity.BookTransaction;

public interface BookTransactionService {
	BookTransaction getById(Long id);

	BookTransaction create(BookTransaction bokkTransaction);

	BookTransaction update(BookTransaction bokkTransaction);
	
	BookTransaction issueBook(Long userId, Long bookId);
	
	BookTransaction returnBook(Long bookTtransactionId);
	
	boolean delete(Long id);

	List<BookTransaction> getAll();
}