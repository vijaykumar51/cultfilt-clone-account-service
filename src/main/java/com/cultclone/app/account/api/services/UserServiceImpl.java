package com.cultclone.app.account.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;
import com.cultclone.app.account.api.models.data.UserEntity;
import com.cultclone.app.account.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserResponseModel getUserById(String userId) {
		UserEntity userEntity = userRepo.findByUserId(userId);
		UserResponseModel userResponseModel = new UserResponseModel();
		BeanUtils.copyProperties(userEntity, userResponseModel);
		return userResponseModel;
	}

	@Override
	public UserResponseModel getUserByEmail(String email) {
		UserEntity userEntity = userRepo.findByEmail(email);
		if (userEntity != null) {
			UserResponseModel userResponseModel = new UserResponseModel();
			BeanUtils.copyProperties(userEntity, userResponseModel);
			return userResponseModel;
		}
		return null;
	}

	@Override
	public UserResponseModel saveUser(UserRequestModel userRequestModel) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userRequestModel, userEntity);
		userEntity.setPassword(bCryptPasswordEncoder.encode(userRequestModel.getPassword()));
		userEntity.setUserId(userRequestModel.getEmail());
		System.out.println("userEntity" + userEntity.toString());
		userEntity = userRepo.save(userEntity);

		UserResponseModel userResponseModel = new UserResponseModel();
		BeanUtils.copyProperties(userEntity, userResponseModel);

		return userResponseModel;
	}

	@Override
	public List<UserResponseModel> getAllUser() {

		List<UserEntity> users = userRepo.findAll();
		List<UserResponseModel> usersResponse = users.stream()
				.map(user -> modelMapper.map(user, UserResponseModel.class)).collect(Collectors.toList());

		return usersResponse;
	}

}
