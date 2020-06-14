package com.cultclone.app.account.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cultclone.app.account.api.models.UserRequestModel;
import com.cultclone.app.account.api.models.UserResponseModel;
import com.cultclone.app.account.api.services.UserService;

@RestController
@RequestMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<String> getUser() {
		return ResponseEntity.status(HttpStatus.OK).body("user service working..");
	}

	@PostMapping
	public ResponseEntity<UserResponseModel> saveUser(@RequestBody UserRequestModel userRequestModel) {
		UserResponseModel userResponseModel = userService.saveUser(userRequestModel);
		return ResponseEntity.status(HttpStatus.OK).body(userResponseModel);
	}

}
