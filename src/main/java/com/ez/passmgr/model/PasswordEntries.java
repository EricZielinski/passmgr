package com.ez.passmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PASSWORD_ENTRIES")
@RequiredArgsConstructor
@NoArgsConstructor
public class PasswordEntries {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private Long id; //Required by Hibernate but not really needed
	
	
	@Column(name="USERNAME",nullable=false)
	@Getter
	@Setter
	@NonNull
	private String username;
	
	
	@Column(name="PASSWORD",nullable=false)
	@Getter
	@Setter
	@NonNull
	private String password;
	
	
	@Column(name="TITLE",nullable=false)
	@Getter
	@Setter
	@NonNull
	private String title;
	
	
	@Column(name="URL")
	@Getter
	@Setter
	@NonNull //may change
	private String url;
	
	
	@ManyToOne
	@Getter
	private User user;


}
