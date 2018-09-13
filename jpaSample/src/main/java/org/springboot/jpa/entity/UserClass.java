package org.springboot.jpa.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userClass")
public class UserClass implements Serializable{

	private static final long serialVersionUID = -6370335653140191019L;
	@Id
	@GeneratedValue
	@Column(length=32)
	private Long id;
	@Column(nullable=false,length=32)
	private Long userId;
	@Column(nullable=false,length=50)
	private String className;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = Long.valueOf(UUID.randomUUID().toString().replace("-", ""));
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "UserClass [id=" + id + ", userId=" + userId + ", className=" + className + "]";
	}
}
