package com.cultclone.app.account.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;
import com.cultclone.app.account.api.services.UserService;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserResponseModel> getUser(@PathVariable String userId) {
		UserResponseModel userRecord = userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userRecord);
	}

	@PostMapping
	public ResponseEntity<UserResponseModel> saveUser(@RequestBody UserRequestModel userRequestModel) {
		UserResponseModel userResponseModel = userService.saveUser(userRequestModel);
		return ResponseEntity.status(HttpStatus.OK).body(userResponseModel);
	}

}
