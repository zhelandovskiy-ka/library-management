package com.library;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;
import com.library.util.BookModule;

@ApplicationPath("api")
public class LibraryApplication extends ResourceConfig {
	public LibraryApplication() {
		packages("com.library.controller");
		register(new BookModule());
	}
}
