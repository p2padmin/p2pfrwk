package com.finance.p2p.core.user;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.finance.p2p.common.GenericDaoJpa;

/**
 * User dao.
 *
 * @author MJ
 */
@Repository
public class UserDaoJpa extends GenericDaoJpa<User> implements UserDao{

	/**
	 * Constructor.
	 */
	public UserDaoJpa() {
		super(User.class);
	}

  @Override
  public User findByLogin(String login) {
    Query query = entityManager.createNamedQuery("User.findByLogin", this.entityType);
    query.setParameter("login", login);
    try {
      return (User) query.getSingleResult();
    } catch (NoResultException e) {
    }

    return null;
  }

}
