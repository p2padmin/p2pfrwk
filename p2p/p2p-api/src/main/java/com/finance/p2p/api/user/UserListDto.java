package com.finance.p2p.api.user;

import java.util.List;

public class UserListDto {
  private List<UserDto> users;

  public List<UserDto> getUsers() {
    return users;
  }

  public void setUsers(List<UserDto> users) {
    this.users = users;
  }
}
