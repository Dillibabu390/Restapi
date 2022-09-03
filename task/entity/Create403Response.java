package com.api.task.entity;

public class Create403Response{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public Create403Response(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"Create403Response{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
