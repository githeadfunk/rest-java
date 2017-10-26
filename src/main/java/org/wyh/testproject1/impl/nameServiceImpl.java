package org.wyh.testproject1.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.wyh.testproject1.rest.nameService;

public class nameServiceImpl implements nameService {

	public Response name() {
		Response r = null;
		Map<String, String> resp = new LinkedHashMap<String, String>();

		try {
			resp.put("name", "wyh");
			r = Response.status(Status.OK).entity(resp).header("Access-Control-Allow-Origin", "*").build();
		}
		catch (Exception ex) {
			r = Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}	

		return r;
	}

}
