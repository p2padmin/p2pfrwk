package com.finance.p2p.core.user;

import com.finance.p2p.common.GenericDao;

public interface RoleDao extends GenericDao<Role> {
  /**
   * Retrieves a role by its name.
   */
  public Role findByName(String name);
}
