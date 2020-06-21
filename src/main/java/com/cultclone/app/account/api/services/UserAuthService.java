package com.cultclone.app.account.api.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cultclone.app.account.api.models.data.UserEntity;
import com.cultclone.app.account.api.repository.UserRepository;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside loadUserByUsername [%s]" + username);
		UserEntity userEntity = userRepo.findByEmail(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User [%s] not found" + username);
		}
		return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, new ArrayList<>());
	}

}
