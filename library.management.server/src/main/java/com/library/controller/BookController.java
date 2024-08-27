package com.library.controller;

import java.util.List;

import com.library.entity.Book;
import com.library.service.BookService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("book")
public class BookController {
	@Inject
	private BookService bookService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		return bookService.getAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book createBook(Book book) {
		return bookService.create(book);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book updateBook(Book book) {
		return bookService.update(book);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean deleteBook(@PathParam("id") Long id) {
		return bookService.delete(id);
	}
}