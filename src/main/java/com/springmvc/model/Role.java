package com.springmvc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "role")
	private Set<User_Role> roleUsers;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String name, Set<User_Role> roleUsers) {
		super();
		this.id = id;
		this.name = name;
		this.roleUsers = roleUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User_Role> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(Set<User_Role> roleUsers) {
		this.roleUsers = roleUsers;
	}
	
}
