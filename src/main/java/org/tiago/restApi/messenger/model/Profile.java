package org.tiago.restApi.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Profile {

	private long id;
	private String profilename;
	private String firstName;
	private String lastName;
	private Date created;
	
	
	public Profile() {
		
	}


	public Profile(long id, String profilename, String firstName, String lastName) {

		this.id = id;
		this.profilename = profilename;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProfilename() {
		return profilename;
	}


	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
	
	
	
}
