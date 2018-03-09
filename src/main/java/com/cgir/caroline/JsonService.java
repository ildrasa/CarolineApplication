package com.cgir.caroline;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cgir.caroline.Caroline;

@Path("/caroline")
public class JsonService {

	private Caroline _caroline;

	public JsonService() {
		_caroline = new Caroline();
	}

	/**
	 * constructor for tests
	 * @param caroline
	 */
	public JsonService(Caroline caroline) {
		_caroline = caroline;
	}

	@GET
	@Path("/brunehildetext")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBrunehildeText() {
		String brunehildeText = _caroline.getBrunehildeText();
		return brunehildeText;
	}

	@GET
	@Path("/aliceversion")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAliceVersionInJSON() {
		String carolineVersion = _caroline.getAliceVersion();
		return carolineVersion;
	}
}
