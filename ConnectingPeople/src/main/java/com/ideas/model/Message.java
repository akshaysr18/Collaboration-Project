package com.ideas.model;

public class Message 
{
	private int id;
	private String message;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
		public Message() {}
		
		
		public Message(int id,String message)
		{
			this.id=id;
			this.message=message;
		}	

}
