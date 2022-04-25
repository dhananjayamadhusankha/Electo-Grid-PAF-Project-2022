package org.restapi.crud.emp.resourse;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.emp.model.empmodel;
import org.restapi.crud.emp.service.empservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

	// reading employee details
		@Path("/retrieve")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		public ArrayList<empmodel> getEmp() throws SQLException {
			return service.getEmp();
		}
		
	// searching  employee details
	@Path("/retrieveById/{empId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<empmodel> getEmp (@PathParam("empId") int empId) throws SQLException{
		
		return service.getEmpById(empId);
	}
	
	//update user details 
		@Path("/updateEmp")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public empmodel updateEmp(empmodel emp) {
			return service.updateEmp(emp);
		}
}
