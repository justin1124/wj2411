package com.wj2411.lottery.service;

import com.wj2411.lottery.model.User;

/**
 * 用户相关逻辑处理
 * @author 须俊杰
 * @version 1.0 2012-7-8
 */
public interface UserService {
	/**
	 * 查询所有用户
	 * @return 返回所有用户列表
	 */
	User getUserById(Integer userId);
}
