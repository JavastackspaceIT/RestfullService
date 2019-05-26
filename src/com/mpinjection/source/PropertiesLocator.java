package com.mpinjection.source;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

import com.sun.tracing.dtrace.ProviderAttributes;

@Path("/locator/{location}")
public class PropertiesLocator {
	/***
	 * 
	 * This is method is used for matrix parameter .
	 **
	 * uri=http://localhost:8088/MatrixParameterInjection/api/locator/hyderabad/property/land;max=50;min=90
	 **/
	
	//getProperties for getting 
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/property/{ptype}")
	public String getProperties(@PathParam("location") String location, @QueryParam("ptype") String property,
			@MatrixParam("max") int max, @MatrixParam("min") int min) {
		System.out.println(max + " " + min);
		return "<getProperties><location>" + location + "</location><property>" + property
				+ "</property></getProperties>";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/details")
	public String getPropertiesDetails(@PathParam("location") String location,
			@QueryParam("ptype") List<String> ptype) {
		return location + " " + ptype;
	}
//getProperties
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/segment")
	public String getProperties(@PathParam("location") PathSegment locationSegment, @MatrixParam("segment") int area) {
		String path = locationSegment.getPath();
		System.out.println(path);
		return null;
	}
}
