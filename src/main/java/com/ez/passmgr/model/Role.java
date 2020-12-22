package com.ez.passmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
	
	public enum Roles {
		USER;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	@Enumerated(EnumType.STRING)
	private Roles name;
			
	public Roles getName() {
		return name;
	}
	public void setName(Roles name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Role(Roles name) {
		super();
		this.name=name;
	}
	
	public Role() {
		super();
	}
	
	
	
}
