package com.javacodegeeks.enterprise.rest.jersey;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dataTransferObjects.User;
import services.Services;
import services.ServicesImpl;

@Path("/jsonServices")
public class JerseyRestService {

	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student produceJSON(@PathParam("name") String name) {

		Student st = new Student(name, "Diaz", 22, 1);

		return st;

	}

	@GET
	@Path("/authenticate/username/{username}/password/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User authenticateUser(@PathParam("username") String name, @PathParam("password") String password) throws ClassNotFoundException, SQLException {

		Services services = new ServicesImpl();

		User user = services.authentificateUser(name, password);

		return user;

	}

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJSON(Student student) {

		String output = student.toString();

		return Response.status(200).entity(output).build();
	}

}
