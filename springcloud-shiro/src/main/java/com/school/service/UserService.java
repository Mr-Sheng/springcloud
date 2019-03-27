package com.school.service;

import com.school.pojo.User;

public interface UserService {

	public User findUserByName(String name);
	
	public User findUserById(Integer id);
	
}
