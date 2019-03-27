package com.school.mapper;

import com.school.pojo.User;

public interface UserMapper {

	public User findUserByName(String name);
	
	public User findUserById(Integer id);
	
}
