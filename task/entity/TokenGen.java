package com.api.task.entity;

public class TokenGen{
	private String type;
	private String token;

	public void setType(String type){
		this.type = type;
	}

	public TokenGen(String type, String token) {
		this.type = type;
		this.token = token;
	}

	public String getType(){
		return type;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"TokenGen{" + 
			"type = '" + type + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
