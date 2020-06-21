package com.cultclone.app.account.api.services;

import java.util.List;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;

public interface UserService {

	public UserResponseModel saveUser(UserRequestModel userRequestModel);

	public UserResponseModel getUserById(String user);

	public UserResponseModel getUserByEmail(String emailId);

	public List<UserResponseModel> getAllUser();

}
