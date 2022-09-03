package com.api.task.entity;

public class LoginRequest{
	private String password;
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public LoginRequest(String password, String email) {
		this.password = password;
		this.email = email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"LoginRequest{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
