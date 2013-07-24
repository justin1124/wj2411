package com.wj2411.lottery.core.admin;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.wj2411.lottery.core.admin.support.User;
import com.wj2411.lottery.core.db.QueryHelper;

/**
 * 用户相关逻辑处理
 * @author 须俊杰
 * @version 1.0 2012-7-8
 */
@Service("userService")
public class UserService{

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
