package com.ez.passmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PASSWORD_ENTRIES")
public class PasswordEntries {
	
	public PasswordEntries() {
		super();
	}

	public PasswordEntries(Long id, String username, String password, String title, String url) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.title = title;
		this.url = url;
	}

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //Required by Hibernate but not really needed
	@Column(name="USERNAME",nullable=false)
	private String username;
	@Column(name="PASSWORD",nullable=false)
	private String password;
	@Column(name="TITLE",nullable=false)
	private String title;
	@Column(name="URL")
	private String url;
	
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
