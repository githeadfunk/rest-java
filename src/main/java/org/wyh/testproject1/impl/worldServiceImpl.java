package org.wyh.testproject1.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.wyh.testproject1.data.worldDAO;
import org.wyh.testproject1.rest.worldService;

public class worldServiceImpl implements worldService {
	
	private worldDAO dao = null;
	
	public worldServiceImpl(){
		dao = new worldDAO();
	}

	@Override
	public Response getCities() {
		Response r = null;
		Map<String, ArrayList<String>> resp = new LinkedHashMap<String, ArrayList<String>>();
		ArrayList<String> cities = null;
		try {
			cities = dao.getAllCities();
			resp.put("world", cities);
			r = Response.status(Status.OK).entity(resp).header("Access-Control-Allow-Origin", "*").build();
		}
		catch (Exception ex) {
			r = Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*").build();
		}	

		return r;
	}

}
