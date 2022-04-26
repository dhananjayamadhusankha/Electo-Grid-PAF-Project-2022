package org.restapi.crud.payment.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.payment.model.paymentmodel;
import org.restapi.crud.payment.service.paymentservice;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;


@Path("/payment")
public class paymentresource {
	
	paymentservice  service = new paymentservice();
	
	//create Payment details
		@Path("/")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public paymentmodel addPayment (paymentmodel payment) {
			return service.insertPayment(payment);
		}

		// reading Payment details
		@Path("/")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		public ArrayList<paymentmodel> getPayment() throws SQLException {
			
			return service.getPayment();
		}

		// searching  power details
		@Path("/{payID}")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		public ArrayList<paymentmodel> getPaymentmodels (@PathParam("payID") int payID) throws SQLException {
			
			return service.getPaymentByID(payID);
		}
		
		//update power details 
		@Path("/")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public paymentmodel updatePayment(paymentmodel payment) {
			return service.updatePayment(payment);
		}
		//delete user details
		@Path("/{payID}")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		public int deletePayment (@PathParam("payID") int payID) {
			return service.deletePayment(payID);
		}
		
		

		
}
