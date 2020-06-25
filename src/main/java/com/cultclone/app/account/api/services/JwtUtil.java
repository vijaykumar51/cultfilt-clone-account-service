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

@Service
public class JwtUtil {

	@Autowired
	private Environment env;

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		String token = Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(
						new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expirationTime"))))
				.signWith(SignatureAlgorithm.HS256, env.getProperty("token.secret")).compact();

		return token;
	}

}
