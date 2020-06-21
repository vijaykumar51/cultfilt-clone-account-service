package com.cultclone.app.account.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cultclone.app.account.api.models.data.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByUserId(String userId);

	UserEntity findByEmail(String email);

}
