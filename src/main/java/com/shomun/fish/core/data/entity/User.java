package com.shomun.fish.core.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="m_users")

public class User extends EntityBase {

	@javax.persistence.Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="login_id")
	private String loginId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_logged_in")
	private boolean isLoggedIn;
	
	@Column(name="last_login_ip")
	private String lastLoginIp;
	
	@Column(name="last_login_time")
	private String lastLoginTime;
	
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="dob")
	private String dateOfBirth;
	
	
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="m_user_address_mapping",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="address_id")})
	private List<Address> addresses;
//	
//	private List<Group> groups;
//	
//	private List<Role> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws Exception {
		//if(!email.contains("@")) throw new Exception("email format exception");
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return addresses;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> addresses) {
		this.addresses = addresses;
	}
//	/**
//	 * @return the groups
//	 */
//	public List<Group> getGroups() {
//		return groups;
//	}
//	/**
//	 * @param groups the groups to set
//	 */
//	public void setGroups(List<Group> groups) {
//		this.groups = groups;
//	}
//	/**
//	 * @return the roles
//	 */
//	public List<Role> getRoles() {
//		return roles;
//	}
//	/**
//	 * @param roles the roles to set
//	 */
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//	
//	public void addGroup(Group group){
//		if(this.groups == null){
//			this.groups = new ArrayList<Group>();
//		}
//		this.groups.add(group);
//	}
//	
//	public void addRole(Role role){
//		if(this.roles == null){
//			this.roles = new ArrayList<Role>();
//		}
//		this.roles.add(role);
//	}
	
	public void addAddress(Address address) {
		if(this.addresses == null){
			this.addresses = new ArrayList<Address>();
		}
		this.addresses.add(address);
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	 
	
	
}
