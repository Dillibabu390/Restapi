package com.api.task.entity;

public class Update404Response{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public Update404Response(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"Update404Response{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
