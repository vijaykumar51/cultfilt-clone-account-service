package com.cultclone.app.account.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cultclone.app.account.api.models.UserResponseModel;
import com.cultclone.app.account.api.services.UserService;

@RestController
public class AdminUserController {

	@Autowired
	private UserService userService;

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping(value = "/admin/api/users")
	public ResponseEntity<List<UserResponseModel>> getAllUsers() {
		List<UserResponseModel> users = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

}
