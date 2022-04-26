package org.restapi.crud.complain.resourse;

import org.restapi.crud.complain.model.compmodel;
import org.restapi.crud.complain.service.compservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/comp")
public class compresourse {
	
	compservice service = new compservice();
	
	//create complain details
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public compmodel addComp (compmodel comp) {
		return service.insertComp(comp);

	}

}