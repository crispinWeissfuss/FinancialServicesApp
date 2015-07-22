package a.restServices;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import c.internalServices.Services;
import c.internalServices.ServicesImpl;
import b.dataTransferObjects.User;

@Path("/vwfsServices")
public class JerseyRestService {

	@GET
	@Path("/authenticateUser/username/{username}/password/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User authenticateUser(@PathParam("username") String name, @PathParam("password") String password) throws ClassNotFoundException, SQLException {

		Services services = new ServicesImpl();

		User user = services.authentificateUser(name, password);

		return user;

	}

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJSON(User user) {

		String output = user.toString();

		return Response.status(200).entity(output).build();
	}

}
