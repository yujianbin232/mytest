package com.itheima.mapper;

import com.itheima.pojo.User;

public interface UserMapper {
	public User queryUserById(Integer id);
	public void insertUser(User user);
}
