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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="USERS")
/*@Accessors(chain = true)*/
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
	@Column(name="ID", updatable=false, nullable=false)
	@Getter
	private UUID id;
	
	
	@Column(name="EMAIL", nullable=false)
	@Getter
	@Setter
	@NonNull
	private String email;
	
	
	@Column(name="PASSWORD",nullable=false)
	@Getter
	@Setter
	@NonNull
	private String password;
	
	
	@OneToMany(mappedBy="user") //Tells Hibernate that the mapping will be done by PassWordEntries
	@Getter
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
	@Getter
	@NonNull
	private Collection<Role> roles;
		
	
}
