package com.api.task.entity;

public class Login404Response{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public Login404Response(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"Login404Response{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
