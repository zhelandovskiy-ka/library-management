package ru.kazhelandovskiy.library.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.kazhelandovskiy.library.model.Book;
import ru.kazhelandovskiy.library.model.BookTransaction;
import ru.kazhelandovskiy.library.model.User;

public class ApiService {
	private static final String API_BASE_URL = "http://localhost:8080/library/api";
	
	private static final String API_BOOK_URL = API_BASE_URL + "/book";
	private static final String API_USER_URL = API_BASE_URL + "/user";
	private static final String API_BOOK_TRANSACTION_URL = API_BASE_URL + "/book-transaction";

	private final HttpClient client;
	private final ObjectMapper mapper;

	public ApiService() {
		this.client = HttpClient.newHttpClient();
		this.mapper = new ObjectMapper();
	}

	public List<Book> getBooks() {
		return getItems(API_BOOK_URL, Book[].class);
	}

	public List<User> getUsers() {
		return getItems(API_USER_URL, User[].class);
	}

	public List<BookTransaction> getBookTransactions() {
		return getItems(API_BOOK_TRANSACTION_URL, BookTransaction[].class);
	}

	public boolean deleteUser(Long id) {
		return deleteItem(API_USER_URL, id);
	}

	public boolean deleteBook(Long id) {
		return deleteItem(API_BOOK_URL, id);
	}

	public boolean deleteBookTransaction(Long id) {
		return deleteItem(API_BOOK_TRANSACTION_URL, id);
	}

	private boolean deleteItem(String apiUrl, Long id) {
		String url = String.format(apiUrl + "/%s", id);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.DELETE()
				.build();
		
		HttpResponse<String> response;
	
			try {
				response = client.send(request, HttpResponse.BodyHandlers.ofString());
				if (response.body().equals("false")) 
					throw new RuntimeException("delete error");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		return false;
	}

	private <T> List<T> getItems(String apiUrl, Class<T[]> modelClass) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(apiUrl))
				.GET()
				.build();
		
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			T[] items = mapper.readValue(response.body(), modelClass);
			
			return Arrays.asList(items);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
}
