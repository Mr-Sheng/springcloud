package com.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.mapper.UserMapper;
import com.school.pojo.User;
import com.school.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByName(String name) {
		return userMapper.findUserByName(name);
	}

	@Override
	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}

}
