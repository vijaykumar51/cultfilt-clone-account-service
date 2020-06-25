package com.cultclone.app.account.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cultclone.app.account.api.models.data.UserEntity;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	/**
	 * Find by user id.
	 *
	 * @param userId the user id
	 * @return the user entity
	 */
	UserEntity findByUserId(String userId);

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the user entity
	 */
	UserEntity findByEmail(String email);

}
