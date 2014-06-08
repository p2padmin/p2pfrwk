package com.finance.p2p.core.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.finance.p2p.api.user.RoleDto;
import com.finance.p2p.api.user.UserDto;
import com.finance.p2p.common.P2PEntity;

/**
 * 
 * @author MJ
 */
@Entity
@NamedQueries({ @NamedQuery(name = "User.findByLogin", query = "select u from User u where u.login=:login") })
public class User implements P2PEntity {

	private static final long serialVersionUID = 4656103843455167985L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Role> roles;

	private String login;

	private String password;

	private Boolean active;

	private Boolean registration;

	private String firstName;

	private String lastName;

	public boolean compareLoginName(String login) {
		if (this.login.equals(login))
			return true;
		return false;
	}

	public boolean comparePassword(String password) {
		if (this.password.equals(password))
			return true;
		return false;
	}

	/**
	 * Create the UserDto from brief and detail info
	 * 
	 * @return return a complete user data
	 */
	public UserDto createUserDto() {
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setLogin(login);
		// dto.setPassword(password);
		dto.setActive(active);
		dto.setRegistered(registration);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);

		// Create roles dto
		if (roles != null) {
			List<RoleDto> roleDtos = new ArrayList<RoleDto>();
			for (Role role : roles) {
				roleDtos.add(role.createDto());
			}
			dto.setRoles(roleDtos);
		}
		return dto;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * Populates the user properties.
	 * 
	 * @param dto
	 * @param roleDao
	 */
	public void populate(UserDto dto, RoleDao roleDao) {
		this.login = dto.getLogin();
		this.password = dto.getPassword();
		this.active = dto.isActive();
		this.registration = dto.isRegistered();
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();

		if (this.roles == null) {
			this.roles = new ArrayList<Role>();
		}
		this.roles.clear();
		List<RoleDto> roleDtos = dto.getRoles();
		if (roleDtos != null) {
			for (RoleDto roleDto : roleDtos) {
				Role role = roleDao.findByName(roleDto.getName());
				if (role == null) {
					role = new Role();
					role.populate(roleDto);
				}
				this.roles.add(role);
			}
		}

	}

}
