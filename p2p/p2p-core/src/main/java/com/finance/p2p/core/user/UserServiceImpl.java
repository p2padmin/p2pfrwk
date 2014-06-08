package com.finance.p2p.core.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.p2p.api.user.UserDto;
import com.finance.p2p.api.user.UserListDto;
import com.finance.p2p.api.user.UserService;

/**
 * 
 * @author MJ
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private RoleDao roleDao;

	protected static Logger logger = Logger.getLogger(UserServiceImpl.class);

	/**
	 * Check the login user
	 */
	@Override
	public String checkLogin(String login, String password) {
		logger.debug(" check user login and password");
		List<User> logins = userDao.getAll();
		boolean bname = false, bpassword = false;
		for (User l : logins) {
			bname = l.compareLoginName(login);
			bpassword = l.comparePassword(password);
			if (bname) {
				if (bpassword)
					return "yes";
				else
					return "Password Wrong!";
			}
		}
		return "User Name does not exist";

	}

	/**
	 * Get user information by name
	 */
	@Override
	public UserDto getUserInfo(String login) {
		logger.debug(" get user information by login name");
		User user = userDao.findByLogin(login);
		if (user != null) {
			return user.createUserDto();
		}
		logger.error(" user not found");
		return null;
	}

	@Override
	@Transactional
	public UserListDto saveUsers(UserListDto userList) {
		List<UserDto> userDtos = userList.getUsers();
		List<UserDto> results = new ArrayList<UserDto>();
		if (userDtos != null) {
			for (UserDto dto : userDtos) {
				results.add(saveUser(dto));
			}
		}
		userList.setUsers(results);
		return userList;
	}

	@Override
	public List<UserDto> getAllUserInfo() {
		logger.debug(" Get user information by login name");
		List<User> logins = userDao.getAll();
		List<UserDto> result = new ArrayList<UserDto>();
		for (User l : logins) {
			result.add(l.createUserDto());
		}
		return result;
	}

	@Override
	@Transactional
	public UserDto saveUser(UserDto dto) {
		logger.debug(" Save user");
		User user = null;
		if (dto.getId() != null) {
			user = userDao.get(dto.getId());
			if (user == null) {
				throw new RuntimeException("userbrief with id " + dto.getId()
						+ "not found in database");
			}
		} else if (dto.getLogin() != null) {
			user = userDao.findByLogin(dto.getLogin());
		}
		if (user == null) {
			user = new User();
		}
		// populate the brief info
		user.populate(dto, roleDao);
		logger.debug(" Before save - Recording user with no id");
		userDao.save(user);
		logger.debug(" After save - Recording user with id " + user.getId());
		return user.createUserDto();
	}

	@Override
	@Transactional
	public UserDto deleteUser(Integer id) {
		logger.debug(" Delete User");
		User user = userDao.get(id);
		if (user != null) {
			UserDto result = user.createUserDto();
			userDao.delete(user);
			return result;
		}
		return null;
	}
}
