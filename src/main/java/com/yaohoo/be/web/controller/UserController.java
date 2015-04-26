package com.yaohoo.be.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaohoo.be.dao.entity.User;
import com.yaohoo.be.dao.service.UserManager;
@Controller
public class UserController {
	
	@Resource
	private UserManager userManager;
	
	@RequestMapping("/user/login")
	public String addUser(@RequestParam(required = false) String name,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String phone){
		User user = new User(name,password,phone);
		userManager.addUser(user);
		return "ok";
	}
	
	@RequestMapping("/user/get")
	public String addUser(@RequestParam(required = true) int id){
		User user = userManager.getUserById(id);
		System.out.println(user);
		return "ok";
	}

}
