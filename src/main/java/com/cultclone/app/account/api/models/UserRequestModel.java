package com.cultclone.app.account.api.models;

public class UserRequestModel {
	private String email;

	private String name;

	private String password;

	private boolean isCoach;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCoach() {
		return isCoach;
	}

	public void setCoach(boolean isCoach) {
		this.isCoach = isCoach;
	}

}
