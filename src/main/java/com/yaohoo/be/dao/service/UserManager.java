package com.yaohoo.be.dao.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaohoo.be.dao.entity.User;
import com.yaohoo.be.dao.mapper.UserMapper;

import javax.annotation.Resource;

@Service
public class UserManager {

	@Resource
	private UserMapper userMapper;
	
	@Transactional
	public void addUser(User user){
		userMapper.addUser(user.getName(), user.getPassword(), user.getPhone());
	}
}
