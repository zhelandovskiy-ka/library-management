package com.library.controller;

import java.util.List;

import com.library.entity.User;
import com.library.service.UserService;

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

@Path("user")
public class UserController {
	@Inject
	private UserService userService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User User) {
		return userService.create(User);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User User) {
		return userService.update(User);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean deleteUser(@PathParam("id") Long id) {
		return userService.delete(id);
	}
}
