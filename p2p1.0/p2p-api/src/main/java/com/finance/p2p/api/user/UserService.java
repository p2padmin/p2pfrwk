package com.finance.p2p.api.user;

import java.util.List;

public interface UserService {

    public String checkLogin (String login, String password);


    public UserDto getUserInfo (String login);


    public UserListDto saveUsers (UserListDto userDtos);


    public List<UserDto> getAllUserInfo ();


    public UserDto saveUser (UserDto userbriefDto);


    public UserDto deleteUser (Integer id);

    // public UserDto registerUser(UserDto dto, String callbackUrl);

}
