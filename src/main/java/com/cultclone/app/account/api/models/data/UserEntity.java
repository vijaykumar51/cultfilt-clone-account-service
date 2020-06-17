package com.cultclone.app.account.api.models.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 301827630510265396L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "is_coach")
	private boolean isCoach;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCoach() {
		return isCoach;
	}

	public void setCoach(boolean isCoach) {
		this.isCoach = isCoach;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", isCoach=" + isCoach + "]";
	}

}
