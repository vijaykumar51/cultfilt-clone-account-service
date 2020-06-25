package com.cultclone.app.account.api.models;

/**
 * The Class AuthenticationResponseModel.
 */
public class AuthenticationResponseModel {

	/** The jwt. */
	private String jwt;

	/**
	 * Instantiates a new authentication response model.
	 *
	 * @param jwt the jwt
	 */
	public AuthenticationResponseModel(String jwt) {
		super();
		this.jwt = jwt;
	}

	/**
	 * Gets the jwt.
	 *
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * Sets the jwt.
	 *
	 * @param jwt the new jwt
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
