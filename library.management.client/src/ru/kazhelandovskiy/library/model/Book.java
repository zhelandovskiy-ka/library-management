package ru.kazhelandovskiy.library.model;

public class Book {
	private Long id;
	private String author;
	private String title;
	private int year;
	private String genre;
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
