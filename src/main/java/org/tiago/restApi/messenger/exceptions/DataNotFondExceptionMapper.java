package org.tiago.restApi.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import org.tiago.restApi.messenger.model.ErrorMessage;

@Provider
public class DataNotFondExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "www.tiagoandrem.pt");
		
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
	
	

}
