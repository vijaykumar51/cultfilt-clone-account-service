package com.cultclone.app.account.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cultclone.app.account.api.models.LoginRequestModel;

@Controller
public class AuthenticationController {

	@PostMapping("/api/auth/get-token")
	public String loginUser(@RequestBody LoginRequestModel loginRequestModel) {
		return "Hello user";
	}

	@GetMapping("/")
	public String homePage() {
		return "Welcoem to home page";
	}
}
