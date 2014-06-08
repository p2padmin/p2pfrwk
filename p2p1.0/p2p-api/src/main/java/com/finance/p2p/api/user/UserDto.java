package com.finance.p2p.api.user;

import java.util.List;

public class UserDto {
	private Integer id;
	private boolean active;
	private boolean registered;
	private String login;
	private String password;
	private String lastName;
	private String firstName;
	private List<RoleDto> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Boolean isActive() {
		return this.active;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("user[");
		string.append("id:").append(id).append(",")
				.append("active:").append(active).append(",")
				.append("registered:").append(registered).append(",")
				.append("login:").append(login).append(",")
				.append("password:").append(password).append(",")
				.append("lastName:").append(lastName).append(",")
				.append("firstName:").append(firstName).append(",")
				.append("roles:").append(roles).append("]");
		return string.toString();
	}
}
