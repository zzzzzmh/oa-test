package com.lashou.oa.account.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="think_user")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="logintime")
	private Timestamp logintime;
	
	public Users(){}
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getLogintime() {
		return logintime;
	}
	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}


	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Users)) return false;
		Users u = (Users) o;
		if(u.getId() == this.getId() || u.getUsername().equals(this.getUsername())) {
			return true;
		} else {
			return false;
		}
	}
}
