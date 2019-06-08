package com.example.springbootmybatisdemo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmybatisdemo1.entity.User;
import com.example.springbootmybatisdemo1.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public User selectUser(User user) {
		return userMapper.selectUser(user.getUserName(), user.getPassword());
	}
	
	public int insertUser(User user){
		return userMapper.insert(user);
	}

}
