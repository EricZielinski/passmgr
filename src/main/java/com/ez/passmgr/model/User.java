package com.ez.passmgr.model;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	public User() {
		super();
	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
	@Column(updatable=false, nullable=false)
	private UUID userId;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String email;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER) //Tells Hibernate that the mapping will be done by PassWordEntries
	private Collection<PasswordEntries> passwordEntries;

	public Collection<PasswordEntries> getPasswordEntries() {
		return passwordEntries;
	}

	public void setPasswordEntries(Collection<PasswordEntries> passwordEntries) {
		this.passwordEntries = passwordEntries;
	}

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public UUID getId() {
		return userId;
	}

	public void setId(UUID id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
