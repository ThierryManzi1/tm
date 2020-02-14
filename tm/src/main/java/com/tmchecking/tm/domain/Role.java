package com.tmchecking.tm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name="role")
	private String role;
	
	@OneToOne(mappedBy = "role",cascade = CascadeType.ALL)
	@JoinColumn(name="user",nullable = false)
	private Credential user;
	
	public String getRole() {
		return role;
	}
	
	public Role() {
		
	}
	
	
	public Role(String role) {
		this.role = role;
	}

}
