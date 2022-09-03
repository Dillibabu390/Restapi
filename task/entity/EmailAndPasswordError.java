package com.api.task.entity;

public class EmailAndPasswordError{
	private String message;


	public EmailAndPasswordError(String message) {
		this.message = message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"EmailAndPasswordError{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
