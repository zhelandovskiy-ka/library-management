package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "year_published")
	private int year;

	@Column(name = "genre")
	private String genre;

	@Column(name = "page_count")
	private int pageCount;

	
	public Book() {
		
	}
	
	public Book(Long id, String author, String title, int year, String genre, int pageCount) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", year=" + year + ", genre=" + genre
				+ ", pageCount=" + pageCount + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
