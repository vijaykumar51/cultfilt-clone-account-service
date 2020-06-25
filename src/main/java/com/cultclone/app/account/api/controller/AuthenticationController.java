package com.cultclone.app.account.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cultclone.app.account.api.models.AuthenticationRequestModel;
import com.cultclone.app.account.api.models.AuthenticationResponseModel;
import com.cultclone.app.account.api.services.JwtUtil;
import com.cultclone.app.account.api.services.UserAuthService;

/**
 * The Class AuthenticationController.
 */
@Controller
public class AuthenticationController {

	/** The authentication manager. */
	@Autowired
	AuthenticationManager authenticationManager;

	/** The user auth service. */
	@Autowired
	UserAuthService userAuthService;

	/** The jwt util. */
	@Autowired
	JwtUtil jwtUtil;

	/**
	 * Login user.
	 *
	 * @param loginRequestModel the login request model
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping("/api/auth/get-token")
	public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequestModel loginRequestModel) throws Exception {
		System.out.println("AuthController");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestModel.getEmail(),
					loginRequestModel.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO: log it
			throw new BadCredentialsException("Incorrect username or password", e);
		}

		UserDetails userDetails = userAuthService.loadUserByUsername(loginRequestModel.getEmail());
		String jwt = jwtUtil.generateToken(userDetails);
		System.out.println("jwt => " + jwt);
		return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponseModel(jwt));

	}

}
