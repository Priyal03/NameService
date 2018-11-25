package com.pri.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pri.rest.impl.NameImpl;
import com.pri.rest.vo.RequestVO;
import com.pri.rest.vo.ResponseVO;

@Path("/json")
public class NameService {

	@GET
	@Path("/getName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse() {

		return Response.status(Response.Status.OK).entity("HIII").build();
	}

	@POST
	@Path("/currentTime")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseVO readTimeData(String name) {

		NameImpl impl = new NameImpl();
		ResponseVO response = impl.constructResponse(name);
		
		return response;
		
	}
	
	@POST
	@Path("/getTime")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseVO getTimeData(RequestVO name) {

		NameImpl impl = new NameImpl();
		ResponseVO response = impl.constructResponse(name);
		
		return response;
		
	}
	
}
