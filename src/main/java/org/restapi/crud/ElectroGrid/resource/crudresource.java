package org.restapi.crud.ElectroGrid.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.ElectroGrid.model.crudmodel;
import org.restapi.crud.ElectroGrid.service.crudservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {
	
	crudservice service = new crudservice();
	
	//create user details
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addUser(crudmodel user) {
		return service.insertUser(user);
	}
	
	// reading user details
	@Path("/retrieve")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel> getUser() throws SQLException {
		
		return service.getUser();
	}
	
	// searching  user details
	@Path("/retrieveById/{id}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel> getUser(@PathParam("id") int id) throws SQLException {
		
		return service.getUserById(id);
	}
	

	//update user details 
	@Path("/updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updateUser(crudmodel user) {
		
		return service.updateUser(user);
	}
	
	//delete user details
	@Path("/deleteUserById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		
		return service.deleteUser(id);
	}

}
