package com.wj2411.lottery.service.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.wj2411.lottery.db.QueryHelper;
import com.wj2411.lottery.model.User;
import com.wj2411.lottery.service.UserService;

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
