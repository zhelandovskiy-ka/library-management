package com.library.controller;

import java.util.List;

import com.library.entity.BookTransaction;
import com.library.service.BookTransactionService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("book-transaction")
public class BookTransactionController {
	@Inject
	private BookTransactionService bookTransactionService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<BookTransaction> getAllBooks() {
		return bookTransactionService.getAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookTransaction createBook(BookTransaction bookTransaction) {
		System.out.println(bookTransaction.toString());
		return bookTransactionService.create(bookTransaction);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookTransaction updateBook(BookTransaction bookTransaction) {
		return bookTransactionService.update(bookTransaction);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean deleteBook(@PathParam("id") Long id) {
		return bookTransactionService.delete(id);
	}

	@POST
	@Path("/issue-book")
	@Consumes(MediaType.APPLICATION_JSON)
	public BookTransaction issueBook(@QueryParam("user_id") Long userId, @QueryParam("book_id") Long bookId) {
		return bookTransactionService.issueBook(userId, bookId);
	}

	@POST
	@Path("/return-book/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public BookTransaction returnBook(@PathParam("id") Long transactionId) {
		return bookTransactionService.returnBook(transactionId);
	}

}
