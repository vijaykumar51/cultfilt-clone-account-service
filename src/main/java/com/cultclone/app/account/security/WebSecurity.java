package com.cultclone.app.account.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cultclone.app.account.api.services.UserAuthService;
import com.cultclone.app.account.security.filters.JwtAuthorizationFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class WebSecurity.
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	/** The user auth service. */
	@Autowired
	private UserAuthService userAuthService;

	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api/auth/get-token").permitAll()
				.antMatchers(HttpMethod.POST, "/api/user").permitAll().anyRequest().authenticated().and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), env));

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	/**
	 * Configure.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthService).passwordEncoder(bCryptPasswordEncoder());
	}

	/**
	 * Authentication manager bean.
	 *
	 * @return the authentication manager
	 * @throws Exception the exception
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * B crypt password encoder.
	 *
	 * @return the b crypt password encoder
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
