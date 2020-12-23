package com.ez.passmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ROLE")
@RequiredArgsConstructor
@NoArgsConstructor
public class Role {
	
	public enum Roles {
		USER; //may add more later
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	@Getter
	private Long id;
	
	@Column(name="NAME")
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	@NonNull
	private Roles name;
	
	
}
