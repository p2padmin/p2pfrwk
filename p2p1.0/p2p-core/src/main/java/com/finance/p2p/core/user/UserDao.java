package com.finance.p2p.core.user;
import com.finance.p2p.common.GenericDao;

/**
 * Our User repository.
 *
 * @author MJ
 */
public interface UserDao extends GenericDao<User> {
  public User findByLogin(String login);
}
