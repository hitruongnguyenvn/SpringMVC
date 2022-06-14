package com.unknown.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "userName", columnDefinition = "NVARCHAR(255)")
	private String userName;
	
	@Column(name = "password", columnDefinition = "NVARCHAR(255)")
	private String password;
	
	@Column(name = "fullName", columnDefinition = "NVARCHAR(255)")
	private String fullName;
	
	@Column(name = "status", columnDefinition = "INT")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="roleId", nullable=false)
	private RoleEntity role;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

}
