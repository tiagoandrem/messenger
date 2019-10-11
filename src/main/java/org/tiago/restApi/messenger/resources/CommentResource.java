package org.tiago.restApi.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("*/*")
public class CommentResource {
	
	@GET
	public String test() {
		return "novo test ";
	}
	
	@GET
	@Path("/{commentId}")
	public String Teste2(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return "teste 2 " + commentId + "" + messageId;
	}
	

}
