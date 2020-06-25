package com.cultclone.app.account.api.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The Class JwtUtil.
 */
@Service
public class JwtUtil {

	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * Generate token.
	 *
	 * @param userDetails the user details
	 * @return the string
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(
						new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expirationTime"))))
				.signWith(SignatureAlgorithm.HS256, env.getProperty("token.secret")).compact();
	}

}
