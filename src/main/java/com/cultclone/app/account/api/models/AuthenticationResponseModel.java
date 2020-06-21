package com.cultclone.app.account.api.models;

public class AuthenticationResponseModel {

	private String jwt;

	public AuthenticationResponseModel(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
