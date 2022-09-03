package com.api.task.entity;

public class Delete200Response{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public Delete200Response(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"Delete200Response{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
