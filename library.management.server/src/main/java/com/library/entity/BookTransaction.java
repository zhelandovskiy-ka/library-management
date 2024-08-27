package com.library.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "book_transactions")
public class BookTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "issue_date", nullable = false)
	private LocalDateTime issueDate;
	
	@Column(name = "return_date")
	private LocalDateTime returnDate;
	
	public BookTransaction() {
		
	}

	public BookTransaction(Long id, Book book, User user, LocalDateTime issueDate, LocalDateTime returnDate) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "BookTransaction [id=" + id + ", book=" + book + ", user=" + user + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + "]";
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

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
}
