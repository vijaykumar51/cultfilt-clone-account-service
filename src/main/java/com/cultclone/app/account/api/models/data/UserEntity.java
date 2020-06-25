package com.cultclone.app.account.api.models.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UserEntity.
 */
@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 301827630510265396L;

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;

	/** The user id. */
	@Column(name = "user_id")
	private String userId;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The email. */
	@Column(name = "email")
	private String email;

	/** The password. */
	@Column(name = "password")
	private String password;

	/** The is coach. */
	@Column(name = "is_coach")
	private boolean isCoach;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks if is coach.
	 *
	 * @return true, if is coach
	 */
	public boolean isCoach() {
		return isCoach;
	}

	/**
	 * Sets the coach.
	 *
	 * @param isCoach the new coach
	 */
	public void setCoach(boolean isCoach) {
		this.isCoach = isCoach;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", isCoach=" + isCoach + "]";
	}

}
