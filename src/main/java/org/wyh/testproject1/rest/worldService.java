package org.wyh.testproject1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.GZIP;

@Path("/world")
public interface worldService {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cities")
    @GZIP
	public Response getCities();

}
