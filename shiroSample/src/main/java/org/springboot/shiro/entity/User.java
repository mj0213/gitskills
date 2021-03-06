package org.springboot.shiro.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;



/**
 * 用户表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_user")
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "用户名不能为空")
	private String username;
	@NotEmpty(message="密码不能为空")
	private String password;
	 @ManyToMany(fetch=FetchType.EAGER)
	 @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
	            @JoinColumn(name = "role_id") })
	 private List<Role> roleList;//一个用户具有多个角色
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roleList=" + roleList + "]";
	}
	public User(Integer id, @NotEmpty(message = "用户名不能为空") String username,
			@NotEmpty(message = "密码不能为空") String password, List<Role> roleList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleList = roleList;
	}
	public User() {
		super();
	}
	 
	 @Transient
	 public Set<String> getRolesName(){
		 List<Role> roles = getRoleList();
		 Set<String> set = new HashSet<>();
		 for (Role role : roles) {
			 set.add(role.getRoleName());
	        }
	        return set;
	 }
}
