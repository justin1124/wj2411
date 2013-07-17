package com.lottery.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lottery.model.User;
import com.lottery.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final static Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getuser.html", method = RequestMethod.GET)
	public String getUserById(Model model){
		User user = userService.getUserById(1);
		log.debug(user.getName());
		model.addAttribute("user", user);
		return "user/lottery_user";
	}
}
