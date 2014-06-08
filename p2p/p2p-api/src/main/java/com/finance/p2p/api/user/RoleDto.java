package com.finance.p2p.api.user;

public class RoleDto {
	private Integer id;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("role[");
		string.append("id:").append(id).append(",")
				.append("name:").append(name).append("]");
				
		return string.toString();
	}
}
