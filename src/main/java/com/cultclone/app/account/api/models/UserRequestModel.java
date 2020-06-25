package com.cultclone.app.account.api.models;

/**
 * The Class UserRequestModel.
 */
public class UserRequestModel {

	/** The email. */
	private String email;

	/** The name. */
	private String name;

	/** The password. */
	private String password;

	/** The is coach. */
	private boolean isCoach;

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks if is coach.
	 *
	 * @return true, if is coach
	 */
	public boolean isCoach() {
		return isCoach;
	}

	/**
	 * Sets the coach.
	 *
	 * @param isCoach the new coach
	 */
	public void setCoach(boolean isCoach) {
		this.isCoach = isCoach;
	}

}
