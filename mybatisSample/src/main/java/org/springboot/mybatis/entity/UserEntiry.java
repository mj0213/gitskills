package org.springboot.mybatis.entity;

import java.io.Serializable;

public class UserEntiry implements Serializable{
	
	
	private static final long serialVersionUID = -106341048735226077L;
	private Long id ;
	private String userName;
	private String password;
	private String userSex ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "UserEntiry [id=" + id + ", userName=" + userName + ", password=" + password + ", userSex=" + userSex
				+ "]";
	}

}
