package ru.kazhelandovskiy.library.model;

public class BookTransaction {
	private Long id;
	private Book book;
	private User user;
	private String issueDate;
	private String returnDate;

	public BookTransaction() {

	}

	public BookTransaction(Long id, Book book, User user, String issueDate, String returnDate) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}