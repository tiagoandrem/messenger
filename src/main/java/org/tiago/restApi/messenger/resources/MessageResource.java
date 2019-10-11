package org.tiago.restApi.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.tiago.restApi.messenger.model.Message;
import org.tiago.restApi.messenger.resources.beans.MessageFilterBeans;
import org.tiago.restApi.messenger.service.MessageService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBeans filterBeans){
		
		if( filterBeans.getYear() >=0 ) {
			return messageService.getAllMessagesForYear(filterBeans.getYear());
		}
		if(filterBeans.getStart() > 0 && filterBeans.getSize() > 0) {
			return messageService.getAllPagesPaginated(filterBeans.getStart(), filterBeans.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessages(Message message) {
		
		return messageService.addMessage(message);
	}
	
	@PUT
	public Message updateMessage(@PathParam("messageId") long messageID, Message message) {
		message.setId(messageID);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageID) {
		
		messageService.removeMessage(messageID);
	}
	
		
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") long messageID) {
		
		return messageService.getMessage( messageID);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource commentResource() {
		return new CommentResource();
	}

}
