package com.finance.p2p.core.user;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.finance.p2p.common.GenericDaoJpa;

/**
 * 
 * @author MJ
 */
@Repository
public class RoleDaoJpa extends GenericDaoJpa<Role> implements RoleDao {
	public RoleDaoJpa() {
		super(Role.class);
	}

	@Override
	public Role findByName(String name) {
		try {
			Query query = entityManager.createNamedQuery("Role.getByName",
					this.entityType);
			query.setParameter("name", name);
			return (Role) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return null;
	}
}
