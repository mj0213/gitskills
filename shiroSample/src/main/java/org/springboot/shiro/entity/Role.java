package org.springboot.shiro.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
/**
 * 角色表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String roleName;
	@OneToMany(mappedBy="role",fetch=FetchType.EAGER)
	private List<Permission> permissionList;//一个角色对应多个权限
	@ManyToMany
	@JoinTable(name="t_user_role",joinColumns= {@JoinColumn(name="role_id")},
	inverseJoinColumns= {@JoinColumn(name="user_id")})
	private List<User> userList;//一个角色对应多个用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", permissionList=" + permissionList + ", userList="
				+ userList + "]";
	}
	public Role(Integer id, String roleName, List<Permission> permissionList, List<User> userList) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.permissionList = permissionList;
		this.userList = userList;
	}
	public Role() {
		super();
	}
	@Transient
	public List<String> getPermissionsName(){
		List<String> list = new ArrayList<>();
		List<Permission> perlist = getPermissionList();
		for(Permission per:perlist) {
			list.add(per.getPermissionname());
		}
			return list;	
	}
}
