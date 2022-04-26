package org.restapi.crud.user.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.user.model.usermodel;
import org.restapi.crud.user.service.userservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class userresource {
	
userservice service = new userservice();
	
	//create user details
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public usermodel addUser(usermodel user) {
		return service.insertUser(user);
	}
	
	// reading user details
	@Path("/")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<usermodel> getUser() throws SQLException {
		
		return service.getUser();
	}
	
	// searching  user details
	@Path("/{id}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<usermodel> getUser(@PathParam("id") int id) throws SQLException {
		
		return service.getUserById(id);
	}

	//update user details 
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public usermodel updateUser(usermodel user) {
		
		return service.updateUser(user);
	}
	
	//delete user details
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		
		return service.deleteUser(id);
	}

}
