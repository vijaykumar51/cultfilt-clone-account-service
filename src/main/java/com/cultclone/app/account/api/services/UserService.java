package com.cultclone.app.account.api.services;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;

public interface UserService {
	public UserResponseModel saveUser(UserRequestModel userRequestModel);
}
