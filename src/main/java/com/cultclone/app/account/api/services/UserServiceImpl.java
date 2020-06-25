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

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The user repo. */
	@Autowired
	private UserRepository userRepo;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/** The b crypt password encoder. */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 */
	@Override
	public UserResponseModel getUserById(String userId) {
		UserEntity userEntity = userRepo.findByUserId(userId);
		UserResponseModel userResponseModel = new UserResponseModel();
		BeanUtils.copyProperties(userEntity, userResponseModel);
		return userResponseModel;
	}

	/**
	 * Gets the user by email.
	 *
	 * @param email the email
	 * @return the user by email
	 */
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

	/**
	 * Save user.
	 *
	 * @param userRequestModel the user request model
	 * @return the user response model
	 */
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

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 */
	@Override
	public List<UserResponseModel> getAllUser() {
		List<UserEntity> users = userRepo.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserResponseModel.class)).collect(Collectors.toList());
	}

}
