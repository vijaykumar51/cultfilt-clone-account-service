package com.cultclone.app.account.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserResponseModel saveUser(UserRequestModel userRequestModel) {
		UserResponseModel userResponseModel = new UserResponseModel();
		BeanUtils.copyProperties(userRequestModel, userResponseModel);
		return userResponseModel;
	}

}
