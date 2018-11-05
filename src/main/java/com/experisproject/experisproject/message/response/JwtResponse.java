package com.experisproject.experisproject.message.response;

/*
– JwtResponse.java is returned by SpringBoot server after successful authentication, it contains 2 parts:

JWT Token
Schema Type of Token

*/

public class JwtResponse {
	private String token;
	private String type = "Bearer";

	public JwtResponse(String accesToken){
		this.token = accesToken;
	}

	public String getAccessToken(){
		return token;
	}

	public void setAccessToken(String accessToken){
		this.token = accessToken;
	}

	public String getTokenType(){
		return type;
	}



}
