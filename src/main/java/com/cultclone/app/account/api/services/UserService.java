package com.cultclone.app.account.api.services;

import java.util.List;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Save user.
	 *
	 * @param userRequestModel the user request model
	 * @return the user response model
	 */
	public UserResponseModel saveUser(UserRequestModel userRequestModel);

	/**
	 * Gets the user by id.
	 *
	 * @param user the user
	 * @return the user by id
	 */
	public UserResponseModel getUserById(String user);

	/**
	 * Gets the user by email.
	 *
	 * @param emailId the email id
	 * @return the user by email
	 */
	public UserResponseModel getUserByEmail(String emailId);

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 */
	public List<UserResponseModel> getAllUser();

}
