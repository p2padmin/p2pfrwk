package com.finance.p2p.core.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.finance.p2p.api.user.RoleDto;
import com.finance.p2p.api.utils.P2PEntity;

@Entity
@NamedQueries({
  @NamedQuery(name = "Role.getByName", query = "select r from Role r where r.name=:name")
})
public class Role implements P2PEntity{

	private static final long serialVersionUID = -2492871602893665223L;

	@Id
	@Column(name = "id_role")
	@GeneratedValue
	private Integer id;

	private String name;

	public RoleDto createDto(){
		RoleDto dto = new RoleDto();
		dto.setName(name);
		dto.setId(id);
		return dto;
	}

	public void populate(RoleDto dto) {
	  this.id = dto.getId();
	  this.name = dto.getName();
	}
}
