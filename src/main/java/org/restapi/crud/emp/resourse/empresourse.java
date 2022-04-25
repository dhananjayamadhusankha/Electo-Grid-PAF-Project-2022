package org.restapi.crud.emp.resourse;

import org.restapi.crud.emp.model.empmodel;
import org.restapi.crud.emp.service.empservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/emp")
public class empresourse {
	
	empservice service = new empservice();
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public empmodel addEmp(empmodel emp) {
		return service.insertEmp(emp);
	}

}
