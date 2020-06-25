package com.cultclone.app.account.security.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

/**
 * The Class JwtAuthorizationFilter.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	/** The env. */
	private Environment env;

	/**
	 * Instantiates a new jwt authorization filter.
	 *
	 * @param authenticationManager the authentication manager
	 * @param env                   the env
	 */
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, Environment env) {
		super(authenticationManager);
		this.env = env;
	}

	/**
	 * Do filter internal.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param chain    the chain
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String authHeader = request.getHeader("Authorization");
		System.out.println("authHeader =>  [%s]" + authHeader);
		if (authHeader == null || !authHeader.startsWith("Bearer")) {
			chain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);

	}

	/**
	 * Gets the authentication.
	 *
	 * @param request the request
	 * @return the authentication
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		String token = authHeader.replace("Bearer", "");
		System.out.println("token => [%s]" + token);
		String email = null;
		try {
			email = Jwts.parser().setSigningKey(env.getProperty("token.secret")).parseClaimsJws(token).getBody()
					.getSubject();
			System.out.println("email => [%s]" + email);
			return new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
		} catch (Exception e) {
			System.out.println("Exception while parsing token => [%s]" + e.getMessage());
		}
		return null;

	}

}
