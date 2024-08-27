package com.library.service.impl;

import java.util.List;

import jakarta.inject.Inject;
import com.library.dao.BookTransactionDao;
import com.library.entity.BookTransaction;
import com.library.service.BookTransactionService;

public class BookTransactionServiceImpl implements BookTransactionService {
	private final BookTransactionDao bookTransactionDao;

	@Inject
	public BookTransactionServiceImpl(BookTransactionDao bookTransactionDao) {
		this.bookTransactionDao = bookTransactionDao;
	}

	@Override
	public BookTransaction create(BookTransaction bookTransaction) {
		return bookTransactionDao.create(bookTransaction);
	}

	@Override
	public List<BookTransaction> getAll() {
		return bookTransactionDao.getAll();
	}

	@Override
	public BookTransaction update(BookTransaction bookTransaction) {
		return bookTransactionDao.update(bookTransaction);
	}

	@Override
	public boolean delete(Long id) {
		return bookTransactionDao.delete(id);
	}

	@Override
	public BookTransaction getById(Long id) {
		return bookTransactionDao.getById(id);
	}

	@Override
	public BookTransaction issueBook(Long userId, Long bookId) {
		return bookTransactionDao.issueBook(userId, bookId);
	}

	@Override
	public BookTransaction returnBook(Long bookTtransactionId) {
		return bookTransactionDao.returnBook(bookTtransactionId);
	}
}
