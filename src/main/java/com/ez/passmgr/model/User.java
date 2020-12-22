package com.ez.passmgr.model;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USERS")
public class User {

	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
	@Column(name="ID", updatable=false, nullable=false)
	private UUID id;
	@Column(name="EMAIL", nullable=false)
	private String email;
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@OneToMany(mappedBy="user") //Tells Hibernate that the mapping will be done by PassWordEntries
	private Collection<PasswordEntries> passwordEntries;
	
	//fetches the roles whenever we want info about a user
	//Any changes to the role(s) of the user will cascade down to all child (many-to-many users & roles table) entities
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="USERS_ROLES",
			joinColumns=@JoinColumn(
					name="USER_ID",
					referencedColumnName="id"),
			inverseJoinColumns= @JoinColumn(
					name="ROLE_ID",
					referencedColumnName="id")
			) //Specifies a unidirectional many-many relationship from user to roles
	private Collection<Role> roles;
	
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public User() {
		super();
	}

	public User(String email, String password, Collection<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	

	public Collection<PasswordEntries> getPasswordEntries() {
		return passwordEntries;
	}

	public void setPasswordEntries(Collection<PasswordEntries> passwordEntries) {
		this.passwordEntries = passwordEntries;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	
	
}
