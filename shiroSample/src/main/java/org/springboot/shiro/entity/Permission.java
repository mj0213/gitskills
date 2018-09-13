package org.springboot.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import javax.persistence.GenerationType;
import javax.persistence.FetchType;
/**
 *对应权限
 * @author Administrator
 *
 */
@Entity
@Table(name="t_permission")
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String permissionname;
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;//一个权限对应一个角色
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermissionname() {
		return permissionname;
	}
	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionname=" + permissionname + ", role=" + role + "]";
	}
	public Permission(Integer id, String permissionname, Role role) {
		super();
		this.id = id;
		this.permissionname = permissionname;
		this.role = role;
	}
	public Permission() {
		super();
	}
}
