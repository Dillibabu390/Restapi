package com.api.task.entity;

public class Get404Response{
	private String message;

	public Get404Response(String message) {
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
			"Get404Response{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
