package com.lottery.service.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.lottery.db.QueryHelper;
import com.lottery.model.User;
import com.lottery.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User getUserById(Integer userId) {
		User user = new User();
		try {
			user = QueryHelper.read(User.class, "SELECT id,name,password FROM lottery_user WHERE id = ?", new Object[]{userId});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
